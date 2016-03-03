package ca.blackperl.struts.forms;

import org.apache.struts.action.ActionForm;

public class PersonForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	private String firstname;
	private String lastname;
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
}
