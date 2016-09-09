package ca.blackperl.dwr.bean;

public class PersonForm {
	private String firstname;
	private String lastname;	
	private Long id;
	private Long age;
	
	
	public Long getAge() {
		return age;
	}
	public String getFirstname() {
		return firstname;
	}
	public Long getId() {
		return id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "PersonForm [firstname=" + firstname + ", lastname=" + lastname + ", id=" + id + ", age=" + age + "]";
	}
}
