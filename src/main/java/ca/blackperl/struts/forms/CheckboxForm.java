package ca.blackperl.struts.forms;

import java.util.Arrays;

import javax.servlet.ServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class CheckboxForm extends ActionForm {

	private static final Logger log = LogManager.getLogger(CheckboxForm.class);

	private String[] checkboxGroup = {};
	private String[] boxes = {"one", "two", "three", "four", "five", "six", "seven" };

	public String[] getBoxes() {
		log.entry();
		return boxes;
	}

	public void setBoxes(String[] boxes) {
		log.entry(boxes);
		this.boxes = boxes;
	}

	public String [] getCheckboxGroup() {
		log.entry();
		return checkboxGroup;
	}

	@Override
	public String toString() {
		return "CheckboxForm [checkboxGroup=" + Arrays.toString(checkboxGroup) + "]";
	}

	public void setCheckboxGroup(String[] checkboxGroup) {
		log.entry(checkboxGroup);
		
		this.checkboxGroup = checkboxGroup;
	}

	@Override
	public void reset(ActionMapping arg0, ServletRequest arg1) {
		super.reset(arg0, arg1);
	}
	
}
