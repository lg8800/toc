package com.toc.crc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toc.crc.entity.DataWord;
import com.toc.crc.entity.RequestCrc;
import com.toc.crc.entity.ResponseCrc;

@RestController
public class Controller {
	@PostMapping("/crc")
	ResponseCrc solve(@RequestBody RequestCrc input) {
		ResponseCrc response = new ResponseCrc();
		String data = input.getDataWord();
		DataWord dataWord = new DataWord(data);
		String divisor = input.getDivisor();
		response.setRemainder(encode(dataWord, divisor, 0));
		String receivedMsg = input.getReceivedMsg();
		DataWord code = new DataWord(receivedMsg);
		response.setIsError(decode(code, divisor));
		return response;
	}

	public static String encode(DataWord dataWord, String divisor, int check) {
		String code = dataWord.getData();
		// check whether it is encoding or decoding
		if (check == 0) {
			while (code.length() < (dataWord.getLength() + divisor.length() - 1)) {
				code = code + '0';
			}
		}
		int temp = divisor.length();
		String result = code.substring(0, temp);
		String remain = "";
		for (int i = 0; i < temp; i++) {
			if (result.charAt(i) == divisor.charAt(i)) {
				remain += '0';
			} else {
				remain += '1';
			}
		}
		while (temp < code.length()) {
			String dvs = divisor;
			if (remain.charAt(1) == '1') {
				remain = remain.substring(1, remain.length());
				remain = remain + String.valueOf(code.charAt(temp));
				temp++;
			} else {
				remain = remain.substring(1, remain.length());
				remain = remain + String.valueOf(code.charAt(temp));
				dvs = "";
				for (int i = 0; i < divisor.length(); i++) {
					dvs += 0;
				}
				temp++;
			}
			result = remain;
			remain = "";
			for (int i = 0; i < divisor.length(); i++) {
				if (result.charAt(i) == dvs.charAt(i)) {
					remain += '0';
				} else {
					remain += '1';
				}
			}
		}
		String codeWord;
		String remainder = remain.substring(1, remain.length());
		codeWord = dataWord.getData() + remainder;
		if (check == 0) {
			System.out.println("Remainder: " + remainder);
			System.out.println("Codeword: " + codeWord);
		} else {
			System.out.println("Remainder: " + remainder);
		}
		return remainder;
	}

	public static int decode(DataWord dataWord, String divisor) {
		String remainder = encode(dataWord, divisor, 1);
		boolean syndrome = Integer.parseInt(remainder) == 0;
		if (syndrome == true) {
			System.out.println("Syndrome: 0");
			System.out.println();
			System.out.println("***The codeword isn't in error");
			return 0;
		} else {
			System.out.println("Syndrome: non-zero");
			System.out.println();
			System.out.println("***The codeword is in error");
			return 1;
		}
	}

}
