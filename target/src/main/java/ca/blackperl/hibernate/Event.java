package ca.blackperl.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {
	private Long id;
	private String title;
	private Date date;
	private Set<Person> participants = new HashSet<Person>();

	public Event() {
	}

	public Date getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}

	public Set<Person> getParticipants() {
		return participants;
	}

	public String getTitle() {
		return title;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setParticipants(Set<Person> participants) {
		this.participants = participants;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", date=" + date + "]";
	}
}