package com.toc.crc.entity;

public class ResponseSimpleParity {
	private int isError;
	private String dataAfterParity;

	public ResponseSimpleParity() {
	}

	public ResponseSimpleParity(int isError, String dataAfterParity) {
		this.isError = isError;
		this.dataAfterParity = dataAfterParity;
	}

	public int getIsError() {
		return isError;
	}

	public void setIsError(int isError) {
		this.isError = isError;
	}

	public String getDataAfterParity() {
		return dataAfterParity;
	}

	public void setDataAfterParity(String dataAfterParity) {
		this.dataAfterParity = dataAfterParity;
	}

}
