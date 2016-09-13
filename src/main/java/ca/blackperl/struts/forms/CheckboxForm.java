package ca.blackperl.struts.forms;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class CheckboxForm extends ActionForm {

	private String[] checkboxGroup;

	public String [] getCheckboxGroup() {
		return checkboxGroup;
	}

	@Override
	public String toString() {
		return "CheckboxForm [checkboxGroup=" + Arrays.toString(checkboxGroup) + "]";
	}

	public void setCheckboxGroup(String[] checkboxGroup) {
		this.checkboxGroup = checkboxGroup;
	}

	@Override
	public void reset(ActionMapping arg0, ServletRequest arg1) {
		super.reset(arg0, arg1);
	}
	
}
