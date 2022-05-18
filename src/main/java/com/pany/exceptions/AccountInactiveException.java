package com.pany.exceptions;

public final class AccountInactiveException extends PacerCrawlerException {

	private static final long serialVersionUID = 4082141115164088474L;

	public AccountInactiveException(String message, String pageInfo) {
		super(message, pageInfo);
	}

}
