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
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.forms.ManagerForm;
import ca.blackperl.utils.HibernateUtil;

public class ManagerAction extends DispatchAction {
	private static final Logger logger = LogManager.getLogger(ManagerAction.class);

	public ActionForward addPersonToEvent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		ManagerForm managerForm = (ManagerForm) form;

		try {
			if ("POST".equals(request.getMethod())) {

				addPersonToEvent(errors, managerForm);

			}
			List<Event> events = EventsDB.listEvents();
			List<Person> persons = EventsDB.listPersons();

			managerForm.setEvents(events);
			managerForm.setPersons(persons);

			logger.debug("Added person " + managerForm.getPersonId() + " to event " + managerForm.getEventId());
			return mapping.findForward("success");
		} catch (Exception e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error creating event " + e.getMessage(), false));
			return mapping.getInputForward();
		} finally {
			saveErrors(request, errors);
		}
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

		try {
			List<Event> events = EventsDB.listEvents();
			List<Person> persons = EventsDB.listPersons();

			managerForm.setEvents(events);
			managerForm.setPersons(persons);

			return mapping.findForward("success");
		} catch (Exception e) {
			log.error("Error fetching events and persons: " + e.getMessage());
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error fetching events and persons: " + e.getMessage(), false));
			return mapping.getInputForward();
		} finally {
			saveErrors(request, errors);
		}
	}

	public ActionForward load(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.getInputForward();
	}

	private void addPersonToEvent(ActionErrors errors, ManagerForm managerForm) throws Exception {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Person aPerson = (Person) session.load(Person.class, managerForm.getPersonId());
				Event anEvent = (Event) session.load(Event.class, managerForm.getEventId());
				aPerson.addToEvent(anEvent);
				session.getTransaction().commit();
			} catch (RuntimeException e) {
				log.error("Error adding person to event: " + e.getMessage());
				session.getTransaction().rollback();
				errors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("Error adding person to event: " + e.getMessage(), false));
				throw new Exception(e);
			}
		} catch (RuntimeException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error adding person to event: " + e.getMessage(), false));
			throw new Exception(e);
		}
	}

	@Override
	protected Method getMethod(String name) throws NoSuchMethodException {
		log.debug("getting method for name: " + name);
		return super.getMethod(name);
	}
}