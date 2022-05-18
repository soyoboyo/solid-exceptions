package com.pany.exceptions;

public final class PacerPageInteractionException extends PacerCrawlerException {

	private static final long serialVersionUID = -6125372533730527125L;

	public PacerPageInteractionException(String message, String failingPageInfo) {
		super(message, failingPageInfo);
	}

}
