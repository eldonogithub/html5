package ca.blackperl.struts.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

import ca.blackperl.hibernate.Event;

public class ManagerForm extends ActionForm {

	private long personId;
	private long eventId;

	List<Event> events;

	public long getEventId() {
		return eventId;
	}

	public List<Event> getEvents() {
		return events;
	}

	public long getPersonId() {
		return personId;
	}
	
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "ManagerForm [personId=" + personId + ", eventId=" + eventId + ", events=" + events + "]";
	}
}
