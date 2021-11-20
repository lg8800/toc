package com.toc.crc.entity;

public class RequestHamming {
	private int length;
	private String dataWord;
	private String receivedMsg;

	public RequestHamming() {
	}

	public RequestHamming(int length, String dataWord, String receivedMsg) {
		this.length = length;
		this.dataWord = dataWord;
		this.receivedMsg = receivedMsg;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDataWord() {
		return dataWord;
	}

	public void setDataWord(String dataWord) {
		this.dataWord = dataWord;
	}

	public String getReceivedMsg() {
		return receivedMsg;
	}

	public void setReceivedMsg(String receivedMsg) {
		this.receivedMsg = receivedMsg;
	}

}
