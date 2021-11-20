package com.toc.crc.entity;

public class RequestCrc {
	private String dataWord;
	private String divisor;
	private String receivedMsg;
	
	public RequestCrc() {
	}
	public RequestCrc(String dataWord, String divisor, String receivedMsg) {
		this.dataWord = dataWord;
		this.divisor = divisor;
		this.receivedMsg = receivedMsg;
	}
	public String getDataWord() {
		return dataWord;
	}
	public void setDataWord(String dataWord) {
		this.dataWord = dataWord;
	}
	public String getDivisor() {
		return divisor;
	}
	public void setDivisor(String divisor) {
		this.divisor = divisor;
	}
	public String getReceivedMsg() {
		return receivedMsg;
	}
	public void setReceivedMsg(String receivedMsg) {
		this.receivedMsg = receivedMsg;
	}
	
}
