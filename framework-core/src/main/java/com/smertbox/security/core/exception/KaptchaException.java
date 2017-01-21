package com.smertbox.security.core.exception;

import org.springframework.security.core.AuthenticationException;

public class KaptchaException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public KaptchaException(String msg) {
		super(msg);
	}

}
