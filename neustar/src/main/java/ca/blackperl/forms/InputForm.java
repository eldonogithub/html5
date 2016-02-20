package ca.blackperl.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.ValidatorForm;

public class InputForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String input;

	private String input2;
	public String getInput() {
		return input;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	@Override
	public String toString() {
		return "InputForm [input=" + input + ", input2=" + input2 + "]";
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		System.out.println("validate called");
		
		errors.add(super.validate(mapping, request));

		if ( input == null || ! input.contains("a") ) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("input has no letter a", false));
		}
		return errors;
	}
}
