/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.commons.web.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.util.StringUtils;

/**
 * A JSF converter to pass Long instances.
 */
public class LongConverter implements Converter, Serializable {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 8709423975164637410L;

	/**
	 * Bean constructor.
	 */
	public LongConverter() {
		super();
	}

	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		if (!StringUtils.hasText(value)) {
			return null;
		}
		return Long.valueOf(value);
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		if (value == null || !StringUtils.hasText(value.toString())) {
			return "";
		}
		if (!(value instanceof Long)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a Long.");
		}
		Long l = (Long) value;
		return l.toString();
	}

}
