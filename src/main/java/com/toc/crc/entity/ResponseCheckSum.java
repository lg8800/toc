package com.toc.crc.entity;

public class ResponseCheckSum {
	private String sum;
	private String checkSum;
	private int isError;

	public ResponseCheckSum() {
	}

	public ResponseCheckSum(String sum, String checkSum, int isError) {
		this.sum = sum;
		this.checkSum = checkSum;
		this.isError = isError;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public int getIsError() {
		return isError;
	}

	public void setIsError(int isError) {
		this.isError = isError;
	}

}
