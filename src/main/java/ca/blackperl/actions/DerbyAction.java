package ca.blackperl.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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

public class DerbyAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");

		// Look up our data source
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		// Allocate and use a connection from the pool
		try (Connection conn = ds.getConnection()) {
			PreparedStatement testst = conn.prepareStatement("select * from testdata");

			ResultSet rs = testst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ResultSetMetaData metaData = rs.getMetaData();
					int columnCount = metaData.getColumnCount();
					for (int i = 0; i < columnCount; i++) {
						rs.getString(0);
					}
				}
			}
			return mapping.findForward("success");
		}
		catch( SQLException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Database failed: " + e.getMessage(), false));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}

	}
}
