package ca.blackperl.struts.actions.hibernate;

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
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ca.blackperl.hibernate.HibernateUtil;
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.forms.PersonForm;

public class PersonAction extends Action {
	private static final Logger log = LogManager.getLogger(PersonAction.class);

	private Long createAndStorePerson(ActionErrors errors, String firstname, String lastname) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();

			Person person = new Person();
			person.setFirstname(firstname);
			person.setLastname(lastname);

			log.info("Stored Person: " + person);

			Long saved = (Long) session.save(person);

			session.getTransaction().commit();

			return saved;
		} catch (HibernateException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("Error processing request " + e.getMessage(), false));
			return null;
		}
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		ActionErrors errors = new ActionErrors();
	
		if (isCancelled(request)) {
			log.debug("Request was cancelled");
			return mapping.getInputForward();
		}
		PersonForm personForm = (PersonForm) form;
	
		createAndStorePerson(errors, personForm.getFirstname(), personForm.getLastname());
	
		HibernateUtil.getSessionFactory().close();
	
		saveErrors(request, errors);
	
		return mapping.findForward("success");
	}

}