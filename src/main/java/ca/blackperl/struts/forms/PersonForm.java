package ca.blackperl.struts.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

import ca.blackperl.hibernate.Person;

public class PersonForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	private String firstname;
	private String lastname;
	private List<Person> persons;
	public int getAge() {
		return age;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "PersonForm [age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<Person> getPersons() {
		return persons;
	}
}
