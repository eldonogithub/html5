package ca.blackperl.dwr.bean;

public class Column {
	private String data;
	private String name;
	private boolean searchable;
	private boolean orderable;
	private String value;
	private boolean regex;
	public String getData() {
		return data;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public boolean isOrderable() {
		return orderable;
	}
	public boolean isRegex() {
		return regex;
	}
	public boolean isSearchable() {
		return searchable;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}
	public void setRegex(boolean regex) {
		this.regex = regex;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Column [data=" + data + ", name=" + name + ", searchable=" + searchable + ", orderable=" + orderable
				+ ", value=" + value + ", regex=" + regex + "]";
	}
}
