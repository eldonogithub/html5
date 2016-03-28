package ca.blackperl.dwr.bean;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.blackperl.dwr.enums.Status;

public class AjaxMetaData {

	private static final Logger log = LogManager.getLogger(AjaxMetaData.class);

	Status status;
	String message;
	String debug;
	List<MetaData> results;
	List<String> columns;
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
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
		log.error(debug);
	}
	public List<MetaData> getResults() {
		return results;
	}
	public void setResults(List<MetaData> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "AjaxMetaData [status=" + status + ", message=" + message + ", debug=" + debug + ", results=" + results
				+ "]";
	}
	
}
