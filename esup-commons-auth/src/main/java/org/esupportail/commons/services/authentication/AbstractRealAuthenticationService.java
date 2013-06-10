/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.commons.services.authentication;

import java.util.List;
import java.util.Map;

import org.esupportail.commons.services.authentication.info.AuthInfo;
import org.esupportail.commons.services.authentication.info.AuthInfoImpl;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * An abstract real authenticator.
 */
@SuppressWarnings("serial")
public abstract class AbstractRealAuthenticationService extends AbstractAuthenticationService {

	/**
	 * Bean constructor.
	 */
	protected AbstractRealAuthenticationService() {
		super();
	}

	/**
	 * @return the authentication id, null if not authenticated.
	 */
	protected abstract String getAuthId();

	/**
	 * @return the authentication attributes.
	 */
	protected Map<String, List<String>> getAuthAttributes() {
		return null;
	}

	@Override
	public AuthInfo getAuthInfo() {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
		String authId = getAuthId();
		if (authId == null) {
			return null;
		}
		return new AuthInfoImpl(authId, getAuthType(), getAuthAttributes());
	}

	/**
	 * @return the authType
	 */
	protected abstract String getAuthType();

}
