package com.toc.crc.entity;

public class RequestSimpleParity {
	private String dataWord;
	private int parity;
	private String receivedMsg;

	public RequestSimpleParity() {
	}

	public RequestSimpleParity(String dataWord, int parity, String receivedMsg) {
		this.dataWord = dataWord;
		this.parity = parity;
		this.receivedMsg = receivedMsg;
	}

	public String getDataWord() {
		return dataWord;
	}

	public void setDataWord(String dataWord) {
		this.dataWord = dataWord;
	}

	public int getParity() {
		return parity;
	}

	public void setParity(int parity) {
		this.parity = parity;
	}

	public String getReceivedMsg() {
		return receivedMsg;
	}

	public void setReceivedMsg(String receivedMsg) {
		this.receivedMsg = receivedMsg;
	}

}
