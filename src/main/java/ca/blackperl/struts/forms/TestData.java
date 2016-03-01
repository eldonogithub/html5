package ca.blackperl.struts.forms;

import org.apache.struts.validator.ValidatorForm;

public class TestData extends ValidatorForm {

	/**
	 * Default servialization version
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "TestData [id=" + id + ", name=" + name + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
