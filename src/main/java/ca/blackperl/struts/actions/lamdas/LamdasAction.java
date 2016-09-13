package ca.blackperl.struts.actions.lamdas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LamdasAction extends Action {

	interface MyNumber {
		double getValue();
	}
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// create a lamda;
		MyNumber number = () -> 123.00;
		
		return mapping.findForward("success");
	}
}
