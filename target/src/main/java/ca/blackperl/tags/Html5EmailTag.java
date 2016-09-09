package ca.blackperl.tags;

import javax.servlet.jsp.JspException;

public class Html5EmailTag extends Html5InputTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Html5EmailTag() {
        super();
        this.type = "email";
        doReadonly = false;
	}

}
