package ca.blackperl.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class DerbyForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String inputText;
	String emailAddress;
	String date;
	String website;
	String message;
	
	DatabaseResults results;

	public String getWebsite() {
		return website;
	}

	public DatabaseResults getResults() {
		return results;
	}

	public void setResults(DatabaseResults results) {
		this.results = results;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "DerbyForm [inputText=" + inputText + ", emailAddress=" + emailAddress + ", date=" + date + ", website="
				+ website + ", message=" + message + ", results=" + results + "]";
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
}
