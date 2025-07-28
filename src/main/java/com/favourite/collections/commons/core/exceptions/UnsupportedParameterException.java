/* Collections #2024 */
package com.favourite.collections.commons.core.exceptions;

import java.util.List;

/**
 * A {@link RuntimeException} that is thrown in the case where invalid
 * parameters are sent in the body of the request to the platform api.
 */
public class UnsupportedParameterException extends RuntimeException {

	private final List<String> unsupportedParameters;

	public UnsupportedParameterException(final List<String> unsupportedParameters) {
		this.unsupportedParameters = unsupportedParameters;
	}

	public List<String> getUnsupportedParameters() {
		return this.unsupportedParameters;
	}
}
