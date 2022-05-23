package com.pany.exceptions;

public final class AccountInactiveException extends PacerCrawlerException {

	private static final long serialVersionUID = 4082141115164088474L;
	private static final String message = "Account is inactive";

	public AccountInactiveException(String pageInfo) {
		super(message, pageInfo);
	}

}
