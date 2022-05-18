package com.pany.exceptions;

public class PacerCrawlerException extends Exception {

	private static final long serialVersionUID = 2328597113186059729L;

	private final String pageInfo;

	protected PacerCrawlerException(String message, String pageInfo) {
		super(message);
		this.pageInfo = pageInfo;
	}

	public String getPageInfo() {
		return pageInfo;
	}
}
