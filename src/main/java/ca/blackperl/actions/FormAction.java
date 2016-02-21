package ca.blackperl.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		if ( !isTokenValid(request, true) ) {
			System.err.println("Token is not valid");
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Form already submitted", false));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");

		// Look up our data source
		DataSource ds = (DataSource)
		  envCtx.lookup("jdbc/TestDB");

		// Allocate and use a connection from the pool
		Connection conn = ds.getConnection();
		PreparedStatement testst = conn.prepareStatement("select * from testdata");
		
		ResultSet rs = testst.executeQuery();
		if ( rs != null ) {
			
		}
		conn.close();

			
		return mapping.findForward("success");
	}
}
