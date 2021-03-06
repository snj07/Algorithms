package sort;

/**
 * @author Sanjay 
 * Best Case : O(n) => already sorted
 * Avg Case  : O(n^2)
 * Worst Case: O(n^2)
 */
public class BubbleSort {
	boolean isSwapped = false;

	void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped) {
				break;
			}
		}
	}

	void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		int[] arr = { 4, 5, 2, 1, 7, 8, 6, 9, 3, 0 };
		System.out.println("Array: ");
		obj.printArray(arr);
		obj.sort(arr);
		System.out.println("Sorted Array: ");
		obj.printArray(arr);
	}

}
