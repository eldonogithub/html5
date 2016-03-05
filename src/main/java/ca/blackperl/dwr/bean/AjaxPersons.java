package ca.blackperl.dwr.bean;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.blackperl.dwr.enums.Status;
import ca.blackperl.hibernate.Person;

public class AjaxPersons {
	private static final Logger log = LogManager.getLogger(AjaxPersons.class);

	Status status;
	String message;
	String debug;
	List<Person> results;
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
	public List<Person> getResults() {
		return results;
	}
	public void setResults(List<Person> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "AjaxPersons [status=" + status + ", message=" + message + ", debug=" + debug + ", results=" + results
				+ "]";
	}
	
	
}
