package com.pany.exceptions;

public final class InvalidPacerCredentialsException extends PacerCrawlerException {

	private static final long serialVersionUID = -8663705722080420279L;

	public InvalidPacerCredentialsException(String message, String failingPageInfo) {
		super(message, failingPageInfo);
	}

}
