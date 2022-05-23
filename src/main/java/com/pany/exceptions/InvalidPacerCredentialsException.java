package com.pany.exceptions;

public final class InvalidPacerCredentialsException extends PacerCrawlerException {

	private static final long serialVersionUID = -8663705722080420279L;
	private static final String message = "Invalid Pacer Credentials";

	public InvalidPacerCredentialsException(String failingPageInfo) {
		super(message, failingPageInfo);
	}

}
