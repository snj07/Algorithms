package conversions;

import java.util.HashMap;

public class BinaryToHexadecimal {
	public static String binaryToHexadecimal(int binary) {

		HashMap<Integer, String> hMap = new HashMap<>();
		// String to store hexadecimal code
		String hex = "";
		int i;
		for (i = 0; i < 10; i++) {
			hMap.put(i, String.valueOf(i));
		}
		for (i = 10; i < 16; i++) {
			hMap.put(i, String.valueOf((char) ('A' + i - 10)));
		}
		int currbit;
		while (binary != 0) {
			int code4 = 0; // to store decimal equivalent of number formed by 4 decimal digits
			for (i = 0; i < 4; i++) {
				currbit = binary % 10;
				binary = binary / 10;
				code4 += currbit * Math.pow(2, i);
			}
			hex = hMap.get(code4) + hex;
		}
		return hex;
	}

	public static void main(String[] args) {
		System.out.println(binaryToHexadecimal(11111001));
	}
}
