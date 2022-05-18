package com.pany.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ExceptionCreatorTest {

	@ParameterizedTest
	@MethodSource("provideTestCases")
	public void shouldCreateException(String pageSource, Exception expectedException) {
		//given
		ExceptionCreator objectUnderTest = new ExceptionCreator();

		//when
		PacerCrawlerException result = objectUnderTest.createException(pageSource);

		//then
		Assertions.assertThat(result).isInstanceOf(expectedException.getClass());
		Assertions.assertThat(result.getMessage()).isEqualTo(expectedException.getMessage());
	}

	private static Stream<Arguments> provideTestCases() {
		return Stream.of(
				Arguments.of("Invalid username or password is at the page", new InvalidPacerCredentialsException("Invalid Pacer Credentials", "Invalid username or password is at the page")),
				Arguments.of("Invalid ID or password is at the page", new InvalidPacerCredentialsException("Invalid Pacer Credentials", "Invalid ID or password is at the page")),
				Arguments.of("Pacer filing account is at the page", new PacerFillingAccountException("Pacer Filing account", "Pacer filing account is at the page"))
		);
	}

}
