package ca.blackperl.struts.actions.hibernate;

import java.lang.reflect.InvocationTargetException;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ca.blackperl.hibernate.Event;
import ca.blackperl.struts.forms.EventForm;
import ca.blackperl.utils.HibernateUtil;

public class EventAction extends Action {
	private static final Logger log = LogManager.getLogger(EventAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionErrors errors = new ActionErrors();

		if ("POST".equals(request.getMethod())) {
			if (isCancelled(request)) {
				log.debug("Request was cancelled");
				return mapping.getInputForward();
			}
			EventForm eventForm = (EventForm) form;

			createAndStoreEvent(errors, eventForm);

			List<Event> events = EventsDB.listEvents(errors);

			eventForm.setEvents(events);

			HibernateUtil.getSessionFactory().close();
		}
		saveErrors(request, errors);

		return mapping.findForward("success");
	}

	private Long createAndStoreEvent(ActionErrors errors, EventForm eventForm) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();

			Event theEvent = new Event();
			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dateConverter, java.util.Date.class);
			BeanUtils.copyProperties(theEvent, eventForm);

			Long saved = (Long) session.save(theEvent);

			log.info("Stored Event: " + theEvent);

			session.getTransaction().commit();

			return saved;
		} catch (HibernateException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
			return null;
		} catch (IllegalAccessException e) {
			log.error(e, e);
		} catch (InvocationTargetException e) {
			log.error(e, e);
		}
		return Long.valueOf(0);
	}

}