package ca.blackperl.dwr.bean;

import ca.blackperl.dwr.enums.Status;
import ca.blackperl.hibernate.Person;

public class AjaxPerson {
	Status status;
	String message;
	String debug;
	Person person;
	public String getDebug() {
		return debug;
	}
	public String getMessage() {
		return message;
	}
	public Person getPerson() {
		return person;
	}
	public Status getStatus() {
		return status;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AjaxPerson [status=" + status + ", message=" + message + ", debug=" + debug + ", person=" + person
				+ "]";
	}
}
