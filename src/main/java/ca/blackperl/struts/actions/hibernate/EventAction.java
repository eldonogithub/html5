package ca.blackperl.struts.actions.hibernate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;

import ca.blackperl.hibernate.Event;
import ca.blackperl.struts.forms.EventForm;
import ca.blackperl.utils.HibernateUtil;

public class EventAction extends Action {
	private static final Logger log = LogManager.getLogger(EventAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		EventForm eventForm = (EventForm) form;
		log.debug("received " + eventForm);

		try {
			if ("POST".equals(request.getMethod())) {
				log.debug("form submission");
				if (isCancelled(request)) {
					log.debug("Request was cancelled");
					return mapping.getInputForward();
				}

				createAndStoreEvent(errors, eventForm);

			}
			List<Event> events = EventsDB.listEvents();
			log.debug("Events " + events);

			eventForm.setEvents(events);
			return mapping.findForward("success");
		} catch (Exception e) {
			log.error("Failed to create event: " + e.getMessage());
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error creating event " + e.getMessage(), false));
			return mapping.getInputForward();
		} finally {
			saveErrors(request, errors);
		}
	}

	private void createAndStoreEvent(ActionErrors errors, EventForm eventForm) throws Exception {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();

				Event theEvent = new Event();
				DateConverter dateConverter = new DateConverter();
				dateConverter.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dateConverter, java.util.Date.class);
				BeanUtils.copyProperties(theEvent, eventForm);

				session.save(theEvent);
				
				log.info("Stored Event: " + theEvent);

				session.getTransaction().commit();

			} catch (RuntimeException e) {
				log.error("Error creating event in the database: " + e.getMessage());
				session.getTransaction().rollback();
				errors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("Error creating event in the database: " + e.getMessage(), false));
				throw new Exception(e);
			} catch (Exception e) {
				session.getTransaction().rollback();
				log.error("Error copying properties: " + e.getMessage());
				errors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("Error copying properties: " + e.getMessage(), false));
				throw e;
			}
		} catch (RuntimeException e) {
			log.error("Error getting database session: " + e.getMessage());
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error getting database session: " + e.getMessage(), false));
			throw new Exception(e);
		}
		return;
	}

}