package ca.blackperl.struts.actions.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;

import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.Person;
import ca.blackperl.utils.HibernateUtil;

public class EventsDB {
	private static final Logger log = LogManager.getLogger(EventsDB.class);

	public static List<Event> listEvents(ActionErrors errors) {
	
		@SuppressWarnings("unchecked")
		List<Event> result = new ArrayList<Event>();
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
			session.beginTransaction();
	
			result.addAll(session.createQuery("from Event").list());
	
			session.getTransaction().commit();
		} catch (Exception e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
		}
	
		return result;
	}

	public static List<Person> listPersons(ActionErrors errors) {
		@SuppressWarnings("unchecked")
		List<Person> result = new ArrayList<Person>();
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
			session.beginTransaction();
	
			result.addAll(session.createQuery("from Person").list());
			
			log.debug("Persons: " + result.size());
			session.getTransaction().commit();

		} catch (Exception e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
		}
		return result;
	}

}
