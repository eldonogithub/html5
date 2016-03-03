package ca.blackperl.struts.actions.hibernate;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
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
import ca.blackperl.struts.forms.EventForm;

public class EventAction extends Action {
	private static final Logger logger = LogManager.getLogger(EventAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionErrors errors = new ActionErrors();

		if (isCancelled(request)) {
			logger.debug("Request was cancelled");
			return mapping.getInputForward();
		}
		EventForm eventForm = (EventForm) form;

		createAndStoreEvent(errors, eventForm.getTitle(), eventForm.getDate());

		HibernateUtil.getSessionFactory().close();

		saveErrors(request, errors);

		return mapping.findForward("success");
	}

	private Long createAndStoreEvent(ActionErrors errors, String title, Date theDate) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();

			Event theEvent = new Event();
			theEvent.setTitle(title);
			theEvent.setDate(theDate);

			logger.info("Stored Event: " + theEvent);

			Long saved = (Long) session.save(theEvent);

			session.getTransaction().commit();

			return saved;
		} catch (HibernateException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
			return null;
		}
	}

}