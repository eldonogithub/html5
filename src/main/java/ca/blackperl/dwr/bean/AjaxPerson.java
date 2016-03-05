package ca.blackperl.dwr.bean;

import java.util.List;

import ca.blackperl.dwr.enums.Status;
import ca.blackperl.hibernate.Person;

public class AjaxPerson {
	Status status;
	String message;
	String debug;
	Person person;
	@Override
	public String toString() {
		return "AjaxPerson [status=" + status + ", message=" + message + ", debug=" + debug + ", person=" + person
				+ "]";
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
