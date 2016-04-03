package ca.blackperl.dwr.bean;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import ca.blackperl.dwr.enums.Status;
import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.actions.hibernate.EventsDB;
import ca.blackperl.utils.HibernateUtil;

public class AjaxHibernate {
	private static final Logger log = LogManager.getLogger(AjaxHibernate.class);

	public AjaxPersons getPersons() {
		AjaxPersons ajaxPersons = new AjaxPersons();
		try {
			List<Person> listPersons = EventsDB.listPersons();

			ajaxPersons.setData(listPersons);
			ajaxPersons.setStatus(Status.SUCCESS);
		} catch (Exception e) {
			ajaxPersons.setMessage("Failed to get list of persons: " + e.getMessage());
			ajaxPersons.setStatus(Status.FAILURE);
		}
		return ajaxPersons;
	}

	public AjaxPersons getPersonsPage(DataTablesBean data) {
		log.debug(data);
		AjaxPersons ajaxPersons = new AjaxPersons();
		try {
			List<Person> result = new ArrayList<Person>();
			try {
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();

					if (data.getDraw() < 1) {
						data.setDraw(1);
					}
					int offset = (data.getDraw() - 1) * data.getLength();
					String queryString = "select * from Person offset " + offset + " rows fetch next "
							+ data.getLength() + " rows only";
					log.debug(queryString);
					SQLQuery query = session.createSQLQuery(queryString);
					query.setReadOnly(true);
					query.addEntity(Person.class);
					@SuppressWarnings("unchecked")
					List<Person> list = query.list();

					result.addAll(list);

					log.debug("Persons: " + result.size());

					// In order for DWR to generate a full JSON object of the
					// Person
					// object we need to tell hibernate to preload all the data,
					// for
					// the proxied data. In this case, the email addresses need
					// to
					// be preloaded.
					for (Person p : list) {
						Hibernate.initialize(p.getEmailAddresses());
					}
					session.getTransaction().commit();
				} catch (RuntimeException e) {
					log.error("Error fetching person list: " + e.getMessage());
					session.getTransaction().rollback();
					throw new Exception(e);
				}
			} catch (RuntimeException e) {
				log.error("Error fetching person list: " + e.getMessage());
				throw new Exception(e);
			}

			ajaxPersons.setData(result);
			ajaxPersons.setDraw(data.getDraw());
			ajaxPersons.setRecordsTotal(-1);
			ajaxPersons.setStatus(Status.SUCCESS);
		} catch (Exception e) {
			ajaxPersons.setMessage("Failed to get list of persons: " + e.getMessage());
			ajaxPersons.setStatus(Status.FAILURE);
		}
		return ajaxPersons;
	}

	public AjaxPerson getPerson(Long id) {
		AjaxPerson ajaxPerson = new AjaxPerson();

		try {
			Person person = EventsDB.getPerson(id);
			ajaxPerson.setPerson(person);
			ajaxPerson.setStatus(Status.SUCCESS);
			return ajaxPerson;
		} catch (Exception e) {
			ajaxPerson.setMessage("Failed to get person: " + e.getMessage());
			ajaxPerson.setStatus(Status.FAILURE);
		}
		return ajaxPerson;
	}

	public AjaxPersons submitPerson(PersonForm person) {
		log.debug("received " + person);
		AjaxPersons ajaxPersons = new AjaxPersons();

		try {
			Person newPerson = new Person();
			BeanUtils.copyProperties(newPerson, person);
			log.debug("properties copied");
			EventsDB.createPerson(newPerson);

			List<Person> listPersons = EventsDB.listPersons();

			ajaxPersons.setData(listPersons);
			ajaxPersons.setStatus(Status.SUCCESS);
			return ajaxPersons;
		} catch (Exception e) {
			log.error("Failed to save person: " + e.getMessage());
			ajaxPersons.setMessage("Failed to save Person: " + e.getMessage());
			ajaxPersons.setStatus(Status.FAILURE);
		}
		log.debug("Returning result" + ajaxPersons);
		return ajaxPersons;
	}

	public AjaxEvents getEvents() {
		AjaxEvents ajaxEvents = new AjaxEvents();

		try {
			List<Event> listEvents = EventsDB.listEvents();
			ajaxEvents.setResults(listEvents);
			ajaxEvents.setStatus(Status.SUCCESS);
			return ajaxEvents;
		} catch (Exception e) {
			ajaxEvents.setMessage("Failed to get list of events: " + e.getMessage());
			ajaxEvents.setStatus(Status.FAILURE);
		}
		return ajaxEvents;
	}

	public AjaxAddEmailToPerson addEmailToPerson(Long personId, String emailAddress) {
		AjaxAddEmailToPerson addEmailToPerson = new AjaxAddEmailToPerson();

		try {
			EventsDB.addEmailToPerson(personId, emailAddress);
			addEmailToPerson.setStatus(Status.SUCCESS);
		} catch (Exception e) {
			addEmailToPerson.setMessage("Failed to add email to person: " + e.getMessage());
			addEmailToPerson.setStatus(Status.FAILURE);
		}
		return addEmailToPerson;
	}

	public AjaxMetaData getTables() {
		log.debug("Fetching toursdb info");

		AjaxMetaData ajaxResults = new AjaxMetaData();
		try {
			DataSource ds = AjaxBean.getDataSource("toursDb");
			try (Connection connection = ds.getConnection()) {
				DatabaseMetaData metaData = connection.getMetaData();

				try (ResultSet tables = metaData.getTables(null, null, null, null)) {
					ResultSetMetaData rsmeta = tables.getMetaData();
					int columnCount = rsmeta.getColumnCount();
					List<String> header = new ArrayList<String>();
					log.debug("Total columns: " + columnCount);
					for (int i = 1; i <= columnCount; i++) {
						log.debug("column[" + i + "] " + rsmeta.getColumnName(i));
						header.add(rsmeta.getColumnName(i));
					}

					String[] columns = new String[] { "tableCat", "tableSchema", "tableName", "tableType", "remarks",
							"typeCat", "typeSchem", "typeName", "selfReferencingColName", "refgenerationString" };

					List<MetaData> datarows = new ArrayList<MetaData>();
					while (tables.next()) {
						MetaData row = new MetaData();

						for (int i = 1; i <= columnCount; i++) {
							BeanUtils.setProperty(row, columns[i - 1], tables.getString(i));
						}
						datarows.add(row);
						log.debug(row);
					}

					ajaxResults.setResults(datarows);
					ajaxResults.setStatus(Status.SUCCESS);
					ajaxResults.setColumns(header);
				}
			}
		} catch (Throwable e) {
			ajaxResults.setStatus(Status.FAILURE);
			log.error(e, e);
			ajaxResults.setDebug(e.getMessage());
		}
		return ajaxResults;
	}
}
