package com.toc.crc.entity;

public class RequestCheckSum {
	private int length;
	private String segment1;
	private String segment2;
	private String receivedCheckSum;

	public RequestCheckSum() {
	}

	public RequestCheckSum(String segment1, String segment2, String receivedCheckSum, int length) {
		this.segment1 = segment1;
		this.segment2 = segment2;
		this.receivedCheckSum = receivedCheckSum;
		this.length = length;
	}

	public String getSegment1() {
		return segment1;
	}

	public void setSegment1(String segment1) {
		this.segment1 = segment1;
	}

	public String getSegment2() {
		return segment2;
	}

	public void setSegment2(String segment2) {
		this.segment2 = segment2;
	}

	public String getReceivedCheckSum() {
		return receivedCheckSum;
	}

	public void setReceivedCheckSum(String receivedCheckSum) {
		this.receivedCheckSum = receivedCheckSum;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}