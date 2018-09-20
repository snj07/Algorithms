package dp;

import java.io.IOException;
import java.util.Scanner;

//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class MaxSumNonAdjac {
	// Maximum sum such that no two elements are adjacent
	static int maxSubsetSum(int[] arr) {
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < arr.length; i++) {
			excl_new = (incl > excl) ? incl : excl;

			incl = excl + arr[i];
			excl = excl_new;
		}

		return ((incl > excl) ? incl : excl);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int arr[] = { 5, -7, 10, 5, 7, 9 };
		int res = maxSubsetSum(arr);

		System.out.println(String.valueOf(res));

		scanner.close();
	}
}
