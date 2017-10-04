package ca.blackperl.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.blackperl.struts.forms.FileForm;

public class UploadFileAction extends Action {
	private static final Logger log = LogManager.getLogger(UploadFileAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileForm fileForm = (FileForm) form;
		log.info("file content=" + fileForm.getFile().getContentType());
		return mapping.findForward("success");
	}
}
