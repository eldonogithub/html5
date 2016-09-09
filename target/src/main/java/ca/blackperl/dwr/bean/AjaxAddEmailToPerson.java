package ca.blackperl.dwr.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.blackperl.dwr.enums.Status;

public class AjaxAddEmailToPerson {

	private static final Logger log = LogManager.getLogger(AjaxAddEmailToPerson.class);
	Status status;
	String message;
	String debug;
	public String getDebug() {
		return debug;
	}
	public String getMessage() {
		return message;
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
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AjaxAddEmailToPerson [status=" + status + ", message=" + message + ", debug=" + debug + "]";
	}
	
}
