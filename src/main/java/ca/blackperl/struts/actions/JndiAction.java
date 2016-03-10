package ca.blackperl.struts.actions;

import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class JndiAction extends Action {
	private static final Logger log = LogManager.getLogger(JndiAction.class);

	public NamingEnumeration<NameClassPair> getJndi() throws NamingException {
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env"); //$NON-NLS-1$

		NamingEnumeration<NameClassPair> list = envCtx.list("jdbc");
		while (list.hasMoreElements()) {
			NameClassPair nameClassPair = (NameClassPair) list.nextElement();
			
			log.debug(nameClassPair.getName() + " = " + nameClassPair.getClassName());
		}
		return list;

	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NamingEnumeration<NameClassPair> jndi = getJndi();
		
		return mapping.getInputForward();
	}
}
