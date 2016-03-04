package ca.blackperl.struts.actions.hibernate;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.HibernateUtil;
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.forms.ManagerForm;

public class ManagerAction extends DispatchAction {
	private static final Logger logger = LogManager.getLogger(ManagerAction.class);

	public ActionForward addPersonToEvent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();

		ManagerForm managerForm = (ManagerForm) form;
		
		addPersonToEvent(errors, managerForm);

		logger.debug("Added person " + managerForm.getPersonId() + " to event " + managerForm.getEventId() );

		return mapping.findForward("success");
	}

	public ActionForward cancelled(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (isCancelled(request)) {
			log.debug("Request was cancelled");
		}
		return mapping.findForward("success");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ManagerForm managerForm = (ManagerForm) form;

		ActionErrors errors = new ActionErrors();

		List<Event> events = listEvents(errors);
		List<Person> persons = listPersons(errors);
		
		managerForm.setEvents(events);
		managerForm.setPersons(persons);
		
		return mapping.findForward("success");
	}

	private List<Person> listPersons(ActionErrors errors) {
		@SuppressWarnings("unchecked")
		List<Person> result = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();

			result = session.createQuery("from Person").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
		}

		return result;
	}

	public ActionForward load(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.getInputForward();
	}

	private void addPersonToEvent(ActionErrors errors, ManagerForm managerForm) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Person aPerson = (Person) session.load(Person.class, managerForm.getPersonId() );
			Event anEvent = (Event) session.load(Event.class, managerForm.getEventId() );
			aPerson.getEvents().add(anEvent);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
		}
	}

	private List<Event> listEvents(ActionErrors errors) {

		@SuppressWarnings("unchecked")
		List<Event> result = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();

			result = session.createQuery("from Event").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
		}

		return result;
	}

	@Override
	protected Method getMethod(String name) throws NoSuchMethodException {
		// TODO Auto-generated method stub
		return super.getMethod(name);
	}
}