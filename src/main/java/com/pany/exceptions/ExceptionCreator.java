package com.pany.exceptions;

final class ExceptionCreator {

	PacerCrawlerException createException(String pageSource) {
		if (pageSource.contains("Account inactive")) {
			return new AccountInactiveException("Account is inactive", pageSource);
		}
		if (pageSource.contains("Invalid username or password")) {
			return new InvalidPacerCredentialsException("Invalid Pacer Credentials", pageSource);
		}
		if (pageSource.contains("Invalid ID or password")) {
			return new InvalidPacerCredentialsException("Invalid Pacer Credentials", pageSource);
		}
		if (pageSource.contains("Pacer filing account")) {
			return new PacerFillingAccountException("Pacer Filing account", pageSource);
		}
		return new PacerPageInteractionException("Exception when interaction with Page", pageSource);
	}

}
