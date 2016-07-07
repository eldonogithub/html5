package ca.blackperl.struts.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import ca.blackperl.hibernate.Person;

public class PersonForm extends ValidatorForm {
	private static final Logger log = LogManager.getLogger(PersonForm.class);

	/**
	 * 
	 */
	private static final Long serialVersionUID = 1L;
	private String id;
	private String age;
	private String firstname;
	private String lastname;
	private List<Person> persons;
	public String getAge() {
		return age;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getId() {
		return id;
	}
	public String getLastname() {
		return lastname;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "PersonForm [id=" + id + ", age=" + age + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", persons=" + persons + "]";
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		// Is this a form submission?
		if ( "POST".equals(request.getMethod())) {
			errors.add(super.validate(mapping, request));
			if ( errors.size() == 0 ) {
				log.debug("No errors in form");
			}
			else {
				log.debug("Automatic Form validation failed");
			}
		}
		return errors;
	}
}
