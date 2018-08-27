package sort;

import java.util.Random;

public class BogoSort {

	private Random random = new Random();

	public boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] < arr[i])
				return false;
		}
		return true;
	}

	// shuffles
	public void shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int randomIndex = i + random.nextInt(arr.length - i);
			int temp = arr[i];
			arr[i] = arr[randomIndex];
			arr[randomIndex] = temp;
		}
	}

	public void sort(int arr[]) {
		while (!isSorted(arr)) {
			shuffle(arr);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		BogoSort bogoSort = new BogoSort();
		System.out.println("Array: ");
		bogoSort.printArray(arr);
		bogoSort.sort(arr);
		System.out.println("Sorted Array: ");
		bogoSort.printArray(arr);

	}

	public void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
