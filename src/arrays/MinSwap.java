package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Given an array of n distinct elements, 
 * find the minimum number of swaps required to sort the array.
 *
 */

public class MinSwap {
	static class Pair implements Comparable<Pair> {
		int val;
		int pos;

		Pair(int val, int pos) {
			this.val = val;
			this.pos = pos;
		}

		@Override
		public int compareTo(Pair arg0) {
			return this.val - arg0.val;
		}

	}

	public static int minSwaps(int[] arr) {
		ArrayList<Pair> sortPos = new ArrayList<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sortPos.add(new Pair(arr[i], i));
		}
		Collections.sort(sortPos);

		boolean[] isVisited = new boolean[n];
		Arrays.fill(isVisited, false);
		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (isVisited[i] || sortPos.get(i).val == i) {
				continue;
			}

			int cycleSize = 0;
			int j = i;
			while (!isVisited[j]) {
				isVisited[j] = true;
				j = sortPos.get(j).pos;
				cycleSize++;
			}
			ans += cycleSize - 1;
		}
		return ans;
	}
	public static void main(String[] args) {
		int []a = {1, 5, 4, 3, 2};
		System.out.println(minSwaps(a));
	}
}
