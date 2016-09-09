package ca.blackperl.dwr.bean;

import ca.blackperl.dwr.enums.Status;

public class AjaxResults {
	Status status;
	String message;
	String debug;
	DatabaseResults results;
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	public void failue(String message, String debug) {
		this.status = Status.FAILURE;
		this.message = message;
		this.debug = debug;
	}
	public String getMessage() {
		return message;
	}
	public DatabaseResults getResults() {
		return results;
	}
	public Status getStatus() {
		return status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setResults(DatabaseResults results) {
		this.results = results;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public void success(DatabaseResults results) {
		this.status = Status.SUCCESS;
		this.results = results;
	}
	@Override
	public String toString() {
		return "AjaxResults [status=" + status + ", message=" + message + ", results=" + results + ", debug=" + debug
				+ "]";
	}
}
