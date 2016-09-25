package ca.blackperl.struts.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;

public class CheckboxIndexedForm extends ActionForm {

	private static final Logger log = LogManager.getLogger(CheckboxIndexedForm.class);

	List<String> checkboxGroup = new ArrayList<String>();

	public List<String> getCheckboxGroup() {
		log.entry();
		return checkboxGroup;
	}

	public void setCheckboxGroup(List<String> checkboxGroup) {
		log.entry(checkboxGroup);
		this.checkboxGroup = checkboxGroup;
	}

	public String getCheckboxGroup(int index) {
		log.entry(index);
		return checkboxGroup.get(index);
	}

	public void setCheckboxGroup(int index, String value) {
		log.entry(index,value);
		this.checkboxGroup.add(index, value);
	}

	@Override
	public String toString() {
		return "CheckboxIndexedForm [checkboxGroup=" + checkboxGroup + "]";
	}
}
