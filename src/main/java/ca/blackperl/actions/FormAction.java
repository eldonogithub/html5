package ca.blackperl.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class FormAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		if ( isTokenValid(request, true) ) {
			System.out.println("Token is valid");
			return mapping.findForward("success");
		}
		else {
			System.err.println("Token is not valid");
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Form already submitted", false));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
	}
}
