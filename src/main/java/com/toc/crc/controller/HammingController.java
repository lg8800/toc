package com.toc.crc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toc.crc.entity.RequestHamming;
import com.toc.crc.entity.ResponseHamming;

@RestController
@CrossOrigin
public class HammingController {
	@PostMapping("/hamming-code")
	public ResponseHamming solve(@RequestBody RequestHamming input) {
		ResponseHamming response = new ResponseHamming();

		int M = input.getLength();
		String str = input.getDataWord();

		int r = 1;

		while (Math.pow(2, r) < (M + r + 1)) {
			r++;
		}
		
		int[] ar = generateCode(str, M, r);
		  
        System.out.println("Generated hamming code ");
        ar = calculation(ar, r);
        
        String generatedCode = "";
        String sum = "";
        
        for(int i = 1; i < ar.length; i++) {
        	generatedCode = generatedCode + Character.forDigit(ar[i], 10);
        	if(generatedCode.charAt(i-1) == '0')
        		sum = sum + '1';
        	else
        		sum = sum + '0';
        }

        int isError = 0;
        
        String receivedMsg = input.getReceivedMsg();
        
        for(int i = 0; i < sum.length(); ++i) {
        	if(sum.charAt(i) != receivedMsg.charAt(i)) {
        		isError = i+1;
        		break;
        	}
        }
        
        response.setGeneratedCode(generatedCode);
        response.setIsError(isError);
        
		return response;
	}

	static int[] calculation(int[] ar, int r) {
		for (int i = 0; i < r; i++) {
			int x = (int) Math.pow(2, i);
			for (int j = 1; j < ar.length; j++) {
				if (((j >> i) & 1) == 1) {
					if (x != j)
						ar[x] = ar[x] ^ ar[j];
				}
			}
			System.out.println("r" + x + " = " + ar[x]);
		}

		return ar;
	}

	static int[] generateCode(String str, int M, int r) {
		int[] ar = new int[r + M + 1];
		int j = 0;
		for (int i = 1; i < ar.length; i++) {
			if ((Math.ceil(Math.log(i) / Math.log(2)) - Math.floor(Math.log(i) / Math.log(2))) == 0) {
				ar[i] = 0;
			} else {
				ar[i] = (int) (str.charAt(j) - '0');
				j++;
			}
		}
		return ar;
	}
}
