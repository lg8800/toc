package com.toc.crc.entity;

public class ResponseHamming {
	private String generatedCode;
	private int isError;

	public ResponseHamming() {
	}

	public ResponseHamming(String generatedCode, int isError) {
		this.generatedCode = generatedCode;
		this.isError = isError;
	}

	public String getGeneratedCode() {
		return generatedCode;
	}

	public void setGeneratedCode(String generatedCode) {
		this.generatedCode = generatedCode;
	}

	public int getIsError() {
		return isError;
	}

	public void setIsError(int isError) {
		this.isError = isError;
	}

}
