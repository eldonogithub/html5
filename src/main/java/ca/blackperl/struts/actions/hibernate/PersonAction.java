package ca.blackperl.struts.actions.hibernate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.forms.PersonForm;
import ca.blackperl.utils.HibernateUtil;

public class PersonAction extends Action {
	private static final Logger log = LogManager.getLogger(PersonAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();

		if ("POST".equals(request.getMethod())) {
			log.debug("execute");

			if (isCancelled(request)) {
				log.debug("Request was cancelled");
				return mapping.getInputForward();
			}
			PersonForm personForm = (PersonForm) form;

			log.debug("Creating Person");
			createAndStorePerson(errors, personForm);

			log.debug("Getting persons");
			List<Person> persons = EventsDB.listPersons(errors);

			personForm.setPersons(persons);

			HibernateUtil.getSessionFactory().close();

		}
		saveErrors(request, errors);
		return mapping.findForward("success");
	}

	private Long createAndStorePerson(ActionErrors errors, PersonForm personForm) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();

			Person person = new Person();

			BeanUtils.copyProperties(person, personForm);

			Long saved = (Long) session.save(person);

			log.info("Stored Person: " + person);

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