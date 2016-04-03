package ca.blackperl.dwr.bean;

public class Search {
	private String value;
	private boolean regex;
	public String getValue() {
		return value;
	}
	public boolean isRegex() {
		return regex;
	}
	public void setRegex(boolean regex) {
		this.regex = regex;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Search [value=" + value + ", regex=" + regex + "]";
	}
}
