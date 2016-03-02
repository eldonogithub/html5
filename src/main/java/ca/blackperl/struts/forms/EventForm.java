package ca.blackperl.struts.forms;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.Person;

public class EventForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Event event;
	private Person person;
	private List<Event> events;
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@Override
	public String toString() {
		return "EventForm [event=" + event + ", person=" + person + ", events=" + events + "]";
	}
}
