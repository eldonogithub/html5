package ca.blackperl.dwr.bean;

import ca.blackperl.dwr.enums.Status;

public class AjaxResults {
	Status status;
	String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	DatabaseResults results;
	public DatabaseResults getResults() {
		return results;
	}
	public Status getStatus() {
		return status;
	}
	public void setResults(DatabaseResults results) {
		this.results = results;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AjaxResults [status=" + status + ", message=" + message + ", results=" + results + "]";
	}
}
