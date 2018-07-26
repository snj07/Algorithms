package sort;

/**
 * @author Sanjay Best Case : O(n^2) Avg Case : O(n^2) Worst Case: O(n^2)
 */
public class SelectionSort {

	void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
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
		SelectionSort obj = new SelectionSort();
		int[] arr = { 4, 5, 2, 1, 7, 8, 6, 9, 3, 0 };
		System.out.println("Array: ");
		obj.printArray(arr);
		obj.sort(arr);
		System.out.println("Sorted Array: ");
		obj.printArray(arr);
	}

}
