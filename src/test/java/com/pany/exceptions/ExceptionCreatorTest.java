package com.pany.exceptions;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ExceptionCreatorTest {

	@Test
	@Parameters(method = "provideTestCases")
	public void shouldCreateException(TestCase testCase) {
		//given
		ExceptionCreator objectUnderTest = new ExceptionCreator();

		//when
		PacerCrawlerException result = objectUnderTest.createException(testCase.pageSource);

		//then
		Assertions.assertThat(result).isInstanceOf(testCase.expectedException.getClass());
		Assertions.assertThat(result.getMessage()).isEqualTo(testCase.expectedException.getMessage());
	}

	TestCase[] provideTestCases() {
		//@formatter:off
		return new TestCase[]{
				new TestCase("Invalid username or password is at the page", new InvalidPacerCredentialsException("Invalid Pacer Credentials", "Invalid username or password is at the page")),
				new TestCase("Invalid ID or password is at the page", new InvalidPacerCredentialsException("Invalid Pacer Credentials", "Invalid ID or password is at the page")),
				new TestCase("Pacer filing account is at the page", new PacerFillingAccountException("Pacer Filing account", "Pacer filing account is at the page"))
		};
		//@formatter:on
	}

	private final static class TestCase {
		private final String pageSource;
		private final Exception expectedException;

		private TestCase(String pageSource, Exception expectedException) {
			this.pageSource = pageSource;
			this.expectedException = expectedException;
		}
	}

}
