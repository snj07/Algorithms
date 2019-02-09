package conversions;

public class BinaryToDecimal {

	public static int binaryToDecimal(int binary) {
		int decimal = 0;
		int i = 0;
		while (binary != 0) {
			int x = binary % 10;
			decimal += ((int) (Math.pow(2, i)) * x);
			++i;
			binary /= 10;
		}
		return decimal;
	}

	public static void main(String[] args) {
		System.out.println(binaryToDecimal(1001));
	}

}
