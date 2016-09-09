package ca.blackperl.dwr.bean;

import java.util.List;

import ca.blackperl.dwr.enums.Status;
import ca.blackperl.hibernate.Event;

public class AjaxEvents {

	Status status;
	String message;
	String debug;
	List<Event> results;
	public String getDebug() {
		return debug;
	}
	public String getMessage() {
		return message;
	}
	public List<Event> getResults() {
		return results;
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
	public void setResults(List<Event> results) {
		this.results = results;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AjaxEvents [status=" + status + ", message=" + message + ", debug=" + debug + ", results=" + results
				+ "]";
	}
}
