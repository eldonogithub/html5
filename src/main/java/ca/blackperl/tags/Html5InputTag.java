package ca.blackperl.tags;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;

import org.apache.struts.taglib.html.BaseFieldTag;

/**
 * @author eldon
 *
 */
public class Html5InputTag extends BaseFieldTag implements DynamicAttributes {

	/**
	 * Serialization Version
	 */
	private static final long serialVersionUID = 1L;

	public Html5InputTag() {
        super();
        doReadonly = false;
	}
	/**
	 * HTML5 input placeholder 
	 */
	private String placeholder;
	
	/**
	 * HTML dynamic attributes
	 */
	private Map<String,Object> attributes = new TreeMap<String,Object>();
	
	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	protected void prepareOtherAttributes(StringBuffer handlers) {
		prepareAttribute(handlers, "placeholder", placeholder);
		for (Entry<String, Object> entry : attributes.entrySet()) {
			prepareAttribute(handlers, entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void setDynamicAttribute(String ns, String name, Object value) throws JspException {
		if ( "type".equals(name)) {
			type = name;
		}
		else {
			attributes.put(name, value);
		}
	}
}
