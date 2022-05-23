package com.pany.exceptions;

public final class PacerPageInteractionException extends PacerCrawlerException {

	private static final long serialVersionUID = -6125372533730527125L;
	private static final String message = "Exception when interaction with Page";

	public PacerPageInteractionException(String failingPageInfo) {
		super(message, failingPageInfo);
	}

}
