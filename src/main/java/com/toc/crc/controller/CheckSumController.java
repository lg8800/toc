package com.toc.crc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toc.crc.entity.DataWord;
import com.toc.crc.entity.RequestCheckSum;
import com.toc.crc.entity.ResponseCheckSum;

@CrossOrigin
@RestController
public class CheckSumController {
	@PostMapping("/check-sum")
	public ResponseCheckSum solve(@RequestBody RequestCheckSum input) {
		ResponseCheckSum response = new ResponseCheckSum();

		int length = input.getLength();
		String seg1 = input.getSegment1();
		String seg2 = input.getSegment2();

		DataWord segment1 = new DataWord(seg1);
		DataWord segment2 = new DataWord(seg2);

		String checkSum = encode(segment1, segment2);

		String sum = "";
		
		for(int i = 0; i < checkSum.length(); ++i) {
			char ch = checkSum.charAt(i);
			if(ch == '0')
				sum += '1';
			else
				sum += '0';
		}
		
		response.setSum(sum);
		
		response.setCheckSum(checkSum);

		String ReCheckSum = input.getReceivedCheckSum();

		response.setIsError(decode(segment1, segment2, ReCheckSum));
		
		return response;
	}

	public static String encode(DataWord seg1, DataWord seg2) {
		int summation, sumwrap;
		int s[] = new int[1000];
		int w[] = new int[1000];
		String sum = "";
		String wrap = "";
		String checkSum = "";
		String temp1 = "";
		String temp2 = "";
		int segment1 = Integer.parseInt(seg1.getData(), 2);
		int segment2 = Integer.parseInt(seg2.getData(), 2);
		summation = segment1 + segment2;
		int i = 0;
		while (summation > 0) {
			s[i] = summation % 2;
			summation = summation / 2;
			i++;
		}
		for (int j = i - 1; j >= 0; j--) {
			sum += Integer.toString(s[j]);
		}
		System.out.println("Sum: " + sum);

		if (sum.length() > seg1.getLength()) {
			for (int j = 0; j < sum.length() - seg1.getLength(); j++) {
				temp1 += sum.charAt(j);
			}
			for (int k = sum.length() - seg1.getLength(); k < sum.length(); k++) {
				temp2 += sum.charAt(k);
			}
			int warp1 = Integer.parseInt(temp1, 2);
			int warp2 = Integer.parseInt(temp2, 2);
			sumwrap = warp1 + warp2;
			// System.out.println(sumwrap);
			int h = 0;
			while (sumwrap > 0) {
				w[h] = sumwrap % 2;
				sumwrap = sumwrap / 2;
				h++;
			}
			for (int x = h - 1; x >= 0; x--) {
				wrap += Integer.toString(w[x]);
			}
			System.out.println("Wrapped sum: " + wrap);

			for (int y = 0; y < wrap.length(); y++) {
				if (wrap.charAt(y) == '0') {
					checkSum += '1';
				} else {
					checkSum += '0';
				}
			}
		} else {
			for (int z = 0; z < seg1.getLength(); z++) {
				if (sum.charAt(z) == '0') {
					checkSum += '1';
				} else {
					checkSum += '0';
				}
			}
		}
		System.out.println("checkSum: " + checkSum);
		return checkSum;
	}

	public static int decode(DataWord seg1, DataWord seg2, String cs) {
		int summation, sumwrap;
		int s[] = new int[1000];
		int w[] = new int[1000];
		String sum = "";
		String wrap = "";
		String temp1 = "";
		String temp2 = "";
		String checkSum = "";
		int segment1 = Integer.parseInt(seg1.getData(), 2);
		int segment2 = Integer.parseInt(seg2.getData(), 2);
		int checkS = Integer.parseInt(cs, 2);
		summation = segment1 + segment2 + checkS;
		int i = 0;
		while (summation > 0) {
			s[i] = summation % 2;
			summation = summation / 2;
			i++;
		}
		for (int j = i - 1; j >= 0; j--) {
			sum += Integer.toString(s[j]);
		}
		System.out.println("Segment1: " + seg1.getData());
		System.out.println("Segment2: " + seg2.getData());
		System.out.println("Received Checksum: " + cs);
		System.out.println("Sum: " + sum);
		if (sum.length() > seg1.getLength()) {
			for (int j = 0; j < sum.length() - seg1.getLength(); j++) {
				temp1 += sum.charAt(j);
			}
			for (int k = sum.length() - seg1.getLength(); k < sum.length(); k++) {
				temp2 += sum.charAt(k);
			}
			int warp1 = Integer.parseInt(temp1, 2);
			int warp2 = Integer.parseInt(temp2, 2);
			sumwrap = warp1 + warp2;
			// System.out.println(sumwrap);
			int h = 0;
			while (sumwrap > 0) {
				w[h] = sumwrap % 2;
				sumwrap = sumwrap / 2;
				h++;
			}
			for (int x = h - 1; x >= 0; x--) {
				wrap += Integer.toString(w[x]);
			}
			System.out.println("Wrapped sum: " + wrap);

			for (int y = 0; y < wrap.length(); y++) {
				if (wrap.charAt(y) == '0') {
					checkSum += '1';
				} else {
					checkSum += '0';
				}
			}
		} else {
			for (int z = 0; z < seg1.getLength(); z++) {
				if (sum.charAt(z) == '0') {
					checkSum += '1';
				} else {
					checkSum += '0';
				}
			}
		}
		System.out.println("checkSum: " + checkSum);
		System.out.println();
		if (Integer.parseInt(checkSum) == 0) {
			System.out.println("Syndrome: 0");
			return 0;
		} else {
			System.out.println("Syndrome: non-zero");
			return 1;
		}
	}
}
