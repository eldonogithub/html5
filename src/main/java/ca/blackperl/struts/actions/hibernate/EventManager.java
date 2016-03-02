package ca.blackperl.struts.actions.hibernate;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;

import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.HibernateUtil;
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.forms.EventForm;

public class EventManager extends DispatchAction {
	private static final Logger logger = LogManager.getLogger(EventManager.class);
	 
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EventForm eventForm = (EventForm) form;
		
		List<Event> events = listEvents();
		
		eventForm.setEvents(events);
		
		for (int i = 0; i < events.size(); i++) {
			Event theEvent = events.get(i);
			logger.info("Read Event: " + theEvent);
		}
		return mapping.findForward("success");
	}

	public ActionForward cancelled(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if ( isCancelled(request) ) {
			log.debug("Request was cancelled");
		}
		return mapping.findForward("success");
	}

	public ActionForward load(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.getInputForward();
	}

	public ActionForward store(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if ( isCancelled(request) ) {
			log.debug("Request was cancelled");
			return mapping.getInputForward();
		}
		EventForm eventForm = (EventForm) form;
		
		createAndStoreEvent("My Event", new Date());

		HibernateUtil.getSessionFactory().close();
		return mapping.findForward("success");
	}

	private void createAndStoreEvent(String title, Date theDate) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);

		logger.info("Stored Event: " + theEvent);

		session.save(theEvent);

		session.getTransaction().commit();
	}

	private List<Event> listEvents() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Event> result = session.createQuery("from Event").list();

		session.getTransaction().commit();

		return result;
	}

	@Override
	protected Method getMethod(String name) throws NoSuchMethodException {
		// TODO Auto-generated method stub
		return super.getMethod(name);
	}
	
	private void addPersonToEvent(Long personId, Long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person aPerson = (Person) session.load(Person.class, personId);
		Event anEvent = (Event) session.load(Event.class, eventId);
		aPerson.getEvents().add(anEvent);
		session.getTransaction().commit();
		}
}