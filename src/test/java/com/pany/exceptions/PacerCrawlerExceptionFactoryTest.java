package com.pany.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PacerCrawlerExceptionFactoryTest {

	private final PacerCrawlerExceptionFactory pacerCrawlerExceptionFactory = new PacerCrawlerExceptionFactory();

	@ParameterizedTest
	@MethodSource("provideTestCases")
	void givenPageInfo_shouldReturnExceptionWithMessage(String pageSource, Exception expectedException) {
		//when
		PacerCrawlerException result = pacerCrawlerExceptionFactory.createException(pageSource);

		//then
		Assertions.assertThat(result).isInstanceOf(expectedException.getClass());
		Assertions.assertThat(result.getMessage()).isEqualTo(expectedException.getMessage());
	}

	@Test
	void givenNullPageInfo_shouldThrowNPE() {
		// given
		String pageSource = null;

		// then
		assertThrows(NullPointerException.class,
				() -> pacerCrawlerExceptionFactory.createException(pageSource));
	}

	private static Stream<Arguments> provideTestCases() {
		return Stream.of(
				Arguments.of("Account inactive is at the page", new AccountInactiveException("Account inactive is at the page")),
				Arguments.of("Invalid username or password is at the page", new InvalidPacerCredentialsException("Invalid username or password is at the page")),
				Arguments.of("Invalid ID or password is at the page", new InvalidPacerCredentialsException("Invalid ID or password is at the page")),
				Arguments.of("Pacer filing account is at the page", new PacerFillingAccountException("Pacer filing account is at the page")),
				Arguments.of("nothing here", new PacerPageInteractionException("nothing here"))
		);
	}

}
