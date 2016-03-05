package ca.blackperl.dwr.bean;

import java.util.List;

import org.apache.struts.action.ActionErrors;

import ca.blackperl.dwr.enums.Status;
import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.Person;
import ca.blackperl.struts.actions.hibernate.EventsDB;

public class AjaxHibernate {

	public AjaxPersons getPersons() {
		ActionErrors errors = new ActionErrors();

		List<Person> listPersons = EventsDB.listPersons(errors);

		AjaxPersons ajaxPersons = new AjaxPersons();
		ajaxPersons.setResults(listPersons);
		if (errors.size() > 0) {
			ajaxPersons.setStatus(Status.FAILURE);
		} else {
			if ( listPersons.size() == 0 ) {
				ajaxPersons.setStatus(Status.NOTFOUND);
			}
			else {
				ajaxPersons.setStatus(Status.SUCCESS);
			}
		}
		return ajaxPersons;
	}

	public AjaxPerson getPerson(Long id) {
		ActionErrors errors = new ActionErrors();

		Person person = EventsDB.getPerson(id, errors);

		AjaxPerson ajaxPerson = new AjaxPerson();
		ajaxPerson.setPerson(person);
		if (errors.size() > 0) {
			ajaxPerson.setStatus(Status.FAILURE);
		} else {
			if (person == null) {
				ajaxPerson.setStatus(Status.NOTFOUND);
			} else {
				ajaxPerson.setStatus(Status.SUCCESS);
			}
		}
		return ajaxPerson;
	}

	public AjaxEvents getEvents() {
		ActionErrors errors = new ActionErrors();

		List<Event> listEvents = EventsDB.listEvents(errors);

		AjaxEvents ajaxEvents = new AjaxEvents();
		ajaxEvents.setResults(listEvents);
		if (errors.size() > 0) {
			ajaxEvents.setStatus(Status.FAILURE);
		} else {
			ajaxEvents.setStatus(Status.SUCCESS);
		}
		return ajaxEvents;
	}
}