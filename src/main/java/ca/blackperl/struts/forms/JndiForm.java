package ca.blackperl.struts.forms;

import java.util.List;

import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class JndiForm extends ActionForm {
	
	private List<NameClassPair> list;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		errors.add(super.validate(mapping, request));
		
		return errors;
	}

	@Override
	public String toString() {
		return "JndiForm [list=" + list + "]";
	}

	public List<NameClassPair> getList() {
		return list;
	}

	public void setList(List<NameClassPair> list) {
		this.list = list;
	}
}
