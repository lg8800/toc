package com.toc.crc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toc.crc.entity.RequestSimpleParity;
import com.toc.crc.entity.ResponseSimpleParity;

@CrossOrigin
@RestController
public class SimpleParityController {
	@PostMapping("/simple-parity")
	public ResponseSimpleParity solve(@RequestBody RequestSimpleParity input) {
		ResponseSimpleParity response = new ResponseSimpleParity();

		String dataS = input.getDataWord();
		int option = input.getParity();

		if (option == 1) {
			dataS = even(dataS);
		}

		else {
			dataS = odd(dataS);
		}
		response.setDataAfterParity(dataS);
		String dataR = input.getReceivedMsg();
		response.setIsError(getDataReceiver(dataR, option));
		return response;
	}

	public String even(String dataS) {
		int count1 = 0;
		int i = 0;
		for (i = 0; i < dataS.length(); i++) {
			if (dataS.charAt(i) == '1') {
				count1++;
			}
		}
		if (count1 % 2 == 0) {
			dataS = dataS + '0';
			System.out.println("Data after even parity:");
			for (i = 0; i < dataS.length(); i++) {
				System.out.print(dataS.charAt(i));
			}
		} else {
			dataS = dataS + '1';
			System.out.println("Data after even parity:");
			for (i = 0; i < dataS.length(); i++) {
				System.out.print(dataS.charAt(i));
			}
		}
		return dataS;
	}

	public String odd(String dataS) {
		int count1 = 0;
		int i = 0;
		for (i = 0; i < dataS.length(); i++) {
			if (dataS.charAt(i) == '1') {
				count1++;
			}
		}
		if (count1 % 2 != 0) {
			dataS = dataS + '0';
			System.out.println("Data after odd parity:");
			for (i = 0; i < dataS.length(); i++) {
				System.out.print(dataS.charAt(i));
			}
		} else {
			dataS = dataS + '1';
			System.out.println("Data after odd parity:");
			for (i = 0; i < dataS.length(); i++) {
				System.out.print(dataS.charAt(i));
			}
		}
		return dataS;
	}

	public int getDataReceiver(String dataR, int option) {
		int i = 0, count1 = 0;
		for (i = 0; i < dataR.length(); i++) {
			if (dataR.charAt(i) == '1') {
				count1++;
			}
		}
		if (option == 1) {
			if (count1 % 2 == 0) {
				System.out.println("Data received successfully with no error");
				return 0;
			} else {
				System.out.println("Error has been detected in received data");
				return 1;
			}
		} else {
			if (count1 % 2 != 0) {
				System.out.println("Data received successfully with no error");
				return 0;
			} else {
				System.out.println("Error has been detected in received data");
				return 1;
			}
		}
	}

}
