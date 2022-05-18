package com.pany.exceptions;

public final class PacerFillingAccountException extends PacerCrawlerException {
	private static final long serialVersionUID = -885987156634055755L;

	public PacerFillingAccountException(String message, String failingPageInfo) {
		super(message, failingPageInfo);
	}
}
