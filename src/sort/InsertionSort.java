package sort;

/**
 * @author Sanjay 
 * Best Case : O(n^2) 
 * Avg Case :  O(n^2) 
 * Worst Case: O(n^2)
 */
public class InsertionSort {

	void sort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int value = arr[i];
			int index = i - 1;
			while (index >= 0 && value < arr[index]) {
				arr[index + 1] = arr[index];
				--index;
			}
			arr[index + 1] = value;
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
		InsertionSort obj = new InsertionSort();
		int[] arr = { 4, 5, 2, 1, 7, 8, 6, 9, 3, 0 };
		System.out.println("Array: ");
		obj.printArray(arr);
		obj.sort(arr);
		System.out.println("Sorted Array: ");
		obj.printArray(arr);
	}

}
