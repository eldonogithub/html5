package ca.blackperl.dwr.bean;

import ca.blackperl.dwr.enums.Status;

public class AjaxResults {
	Status status;
	String message;
	DatabaseResults results;
	public void failue(String message) {
		this.status = Status.FAILURE;
		this.message = message;
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
		return "AjaxResults [status=" + status + ", message=" + message + ", results=" + results + "]";
	}
}
