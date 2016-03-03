package ca.blackperl.struts.forms;

import java.util.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import ca.blackperl.hibernate.Event;
import ca.blackperl.hibernate.Person;

public class EventForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private Date date;
	public Date getDate() {
		return date;
	}
	public String getTitle() {
		return title;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "EventForm [title=" + title + ", date=" + date + "]";
	}
}
