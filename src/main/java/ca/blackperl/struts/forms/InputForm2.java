package ca.blackperl.struts.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.ValidatorForm;

public class InputForm2 extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean input1;
	private String input2;

	public Boolean getInput1() {
		return input1;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput1(Boolean input1) {
		this.input1 = input1;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	@Override
	public String toString() {
		return "InputForm2 [input1=" + input1 + ", input2=" + input2 + "]";
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		System.out.println("InputForm2 validate called");

		errors.add(super.validate(mapping, request));

		if (input1 != null && input2 == null) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("input2 must be set with input1", false));
		}
		if (input1 != null && input2 != null && input2.length() < 3) {
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("input2 can not be less than 3 characters", false));
			System.out.println("input2 too short");
		}
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		input1 = null;
	}
}
