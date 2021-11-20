package com.toc.crc.entity;

public class ResponseCrc {
	String remainder;
	int isError;

	public ResponseCrc() {
	}

	public ResponseCrc(String remainder, int isError) {
		this.remainder = remainder;
		this.isError = isError;
	}

	public String getRemainder() {
		return remainder;
	}

	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}

	public int getIsError() {
		return isError;
	}

	public void setIsError(int isError) {
		this.isError = isError;
	}

}
