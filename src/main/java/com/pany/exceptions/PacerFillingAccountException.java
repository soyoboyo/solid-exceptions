package com.pany.exceptions;

public final class PacerFillingAccountException extends PacerCrawlerException {

	private static final long serialVersionUID = -885987156634055755L;
	private static final String message = "Pacer Filing account";

	public PacerFillingAccountException(String failingPageInfo) {
		super(message, failingPageInfo);
	}
}
