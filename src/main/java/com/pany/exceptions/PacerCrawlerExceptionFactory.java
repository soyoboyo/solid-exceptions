package com.pany.exceptions;

import java.util.Objects;

public class PacerCrawlerExceptionFactory {

	public PacerCrawlerException createException(String pageSource) {
		Objects.requireNonNull(pageSource);

		if (pageSource.contains("Account inactive")) {
			return new AccountInactiveException(pageSource);
		} else if (pageSource.contains("Invalid username or password") || pageSource.contains("Invalid ID or password")) {
			return new InvalidPacerCredentialsException(pageSource);
		} else if (pageSource.contains("Pacer filing account")) {
			return new PacerFillingAccountException(pageSource);
		}
		return new PacerPageInteractionException(pageSource);
	}

}
