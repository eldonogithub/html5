package ca.blackperl.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.ValidatorForm;

import ca.blackperl.hibernate.Event;

public class EventForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String date;
	private Date dateDate;
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
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			try {
				dateDate = df.parse(date);
			} catch (ParseException e) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("eventForm.invalid.date", date));
			}
		}
		return errors;
	}
	public Date getDateDate() {
		return dateDate;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
