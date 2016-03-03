package ca.blackperl.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Person {
	// Accessor methods for all properties, private setter for 'id'
	private Long id;
	private int age;
	private String firstname;
	private String lastname;
	private Set<Event> events = new HashSet<Event>();
	
	public int getAge() {
		return age;
	}
	public Set<Event> getEvents() {
		return events;
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
	public void setAge(int age) {
		this.age = age;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
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
		return "Person [id=" + id + ", age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + ", events="
				+ events + "]";
	}

}
