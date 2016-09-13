package ca.blackperl.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.blackperl.struts.forms.CheckboxForm;

public class CheckboxAction extends Action {

	private static final Logger log = LogManager.getLogger(CheckboxAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CheckboxForm checkboxForm = (CheckboxForm) form;
		
		log.info(checkboxForm);

		return mapping.findForward("success");
	}
}
