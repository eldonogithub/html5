package ca.blackperl.struts.actions.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.Person;
import ca.blackperl.utils.HibernateUtil;

//	Chapter 3. Configuration
//	50
//	The Sessions retrieved via getCurrentSession() in
//	the "jta" context are set to automatically flush before the transaction completes, close after
//	the transaction completes, and aggressively release JDBC connections after each statement.
//	This allows the Sessions to be managed by the life cycle of the JTA transaction to which it
//	is associated, keeping user code clean of such management concerns. Your code can either
//	use JTA programmatically through UserTransaction, or (recommended for portable code) use
//	the Hibernate Transaction API to set transaction boundaries.

// From hibernate_reference-3.6.pdf pg 242
// Database transactions are never optional.
// All communication with a database has to occur inside a transaction

public class EventsDB {
	private static final Logger log = LogManager.getLogger(EventsDB.class);

	public static List<Event> listEvents() throws Exception {

		List<Event> result = new ArrayList<Event>();
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Query query = session.createQuery("from Event");
				query.setReadOnly(true);
				@SuppressWarnings("unchecked")
				List<Event> list = query.list();
				result.addAll(list);
				log.debug("Events: " + result.size());
				session.getTransaction().commit();
			} catch (RuntimeException e) {
				log.error("Error fetching event list: " + e);
				session.getTransaction().rollback();
				throw new Exception(e);
			}
		} catch (RuntimeException e) {
			log.error("Error fetching event list: " + e);
			throw new Exception(e);
		}

		return result;
	}

	public static List<Person> listPersons() throws Exception {
		List<Person> result = new ArrayList<Person>();
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();

				Query query = session.createQuery("from Person");
				query.setReadOnly(true);
				@SuppressWarnings("unchecked")
				List<Person> list = query.list();
				result.addAll(list);

				log.debug("Persons: " + result.size());

				// In order for DWR to generate a full JSON object of the Person
				// object we need to tell hibernate to preload all the data, for
				// the proxied data. In this case, the email addresses need to
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
		return result;
	}

	public static Person getPerson(Long id) throws Exception {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			try {
				session.beginTransaction();
				Query query = session.createQuery("from Person where id = :id");
				query.setReadOnly(true);
				Person person = (Person) query.setLong("id", id).setMaxResults(1).uniqueResult();

				session.getTransaction().commit();
				return person;
			} catch (RuntimeException e) {
				log.error("Error fetching person: " + e.getMessage());
				session.getTransaction().rollback();
				throw new Exception(e);
			}
		} catch (RuntimeException e) {
			log.error("Error fetching person: " + e.getMessage());
			throw new Exception(e);
		}
	}

	public static Person addEmailToPerson(Long personId, String emailAddress) throws Exception {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {

				session.beginTransaction();

				Person aPerson = (Person) session.load(Person.class, personId);

				// The getEmailAddresses() might trigger a lazy load of the
				// collection
				aPerson.getEmailAddresses().add(emailAddress);

				session.getTransaction().commit();
				return aPerson;
			} catch (RuntimeException e) {
				log.error("Error adding email to person: " + e.getMessage());
				session.getTransaction().rollback();
				throw new Exception(e);
			}
		} catch (RuntimeException e) {
			log.error("Error adding email to person: " + e.getMessage());
			throw new Exception(e);
		}
	}

	public static void createPerson(Person person) throws Exception {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			try {
				session.beginTransaction();

				session.save(person);

				session.getTransaction().commit();
			} catch (RuntimeException e) {
				log.error("Error creating person: " + e.getMessage());
				session.getTransaction().rollback();
				throw new Exception(e);
			}
		} catch (RuntimeException e) {
			log.error("Error getting database session: " + e.getMessage());
			throw new Exception(e);
		}

	}

}
