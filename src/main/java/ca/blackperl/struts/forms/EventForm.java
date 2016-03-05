package ca.blackperl.struts.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import ca.blackperl.hibernate.Event;

public class EventForm extends ValidatorForm {
	private static final Logger log = LogManager.getLogger(EventForm.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String date;
	private List<Event> events;
	
	public List<Event> getEvents() {
		return events;
	}
	public String getDate() {
		return date;
	}
	public String getTitle() {
		return title;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "EventForm [title=" + title + ", date=" + date + "]";
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		errors.add(super.validate(mapping, request));
		if ( errors.size() == 0 ) {
			log.debug("No errors in form");
		}
		else {
			log.debug("Automatic Form validation failed");
		}
		return errors;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
