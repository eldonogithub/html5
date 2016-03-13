package ca.blackperl.struts.actions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.naming.ResourceLinkRef;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.tomcat.dbcp.dbcp.DelegatingConnection;
import org.apache.tomcat.dbcp.dbcp.PoolingDataSource;

import ca.blackperl.struts.forms.JndiForm;

public class JndiAction extends Action {
	private static final Logger log = LogManager.getLogger(JndiAction.class);

	public List<NameClassPair> getJndi() throws NamingException {
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env"); //$NON-NLS-1$

		NamingEnumeration<NameClassPair> list = envCtx.list("jdbc");
		List<NameClassPair> jndi = new ArrayList<NameClassPair>();

		while (list.hasMoreElements()) {
			NameClassPair nameClassPair = (NameClassPair) list.nextElement();
			jndi.add(nameClassPair);
			log.debug(
					nameClassPair.getName() + " = " + nameClassPair.getClassName() + " " + nameClassPair.isRelative());
			if (nameClassPair.getName().equals("org.apache.naming.ResourceLinkRef")) {
				ResourceLinkRef ref = (ResourceLinkRef) envCtx.lookup("jdbc/" + nameClassPair.getName());
				log.debug("factory = " + ref.getFactoryClassName());
			}
			DataSource datasource = (DataSource) envCtx.lookup("jdbc/" + nameClassPair.getName());
			if (datasource != null) {
				try (Connection connection = datasource.getConnection()) {
					Class<? extends Connection> class1 = connection.getClass();
					log.debug("Connection class = " + class1.getName());
					log.debug("Connection Info " + connection.getClientInfo());
					if (connection instanceof DelegatingConnection) {
						DelegatingConnection pool = (DelegatingConnection) connection;
						log.debug("DelegatingConnection Info " + pool.getClientInfo());
						Connection innermostDelegate = pool.getInnermostDelegate();
						if (innermostDelegate != null) {
							log.debug(innermostDelegate.getClientInfo());
						}
					}
				} catch (SQLException e) {
					log.error(e);
				}
			}
		}
		return jndi;

	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		JndiForm jndiForm = (JndiForm) form;

		List<NameClassPair> jndi = getJndi();

		jndiForm.setList(jndi);

		return mapping.getInputForward();
	}
}
