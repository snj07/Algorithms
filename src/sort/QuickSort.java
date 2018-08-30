package sort;

public class QuickSort {

	public void sort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			sort(arr, left, pivot - 1);
			sort(arr, pivot , right);
		}
	}

	public int partition(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		int pivot = arr[mid];
		while (left <= right) {
			while (arr[left] < pivot) {
				++left;
			}
			while (pivot < arr[right]) {
				--right;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				++left;
				--right;
			}
			
		}
		return left;
	}

	public static void main(String[] args) {

		int[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		QuickSort quickSort = new QuickSort();
		System.out.println("Array: ");
		quickSort.printArray(arr);
		quickSort.sort(arr, 0, arr.length-1);
		System.out.println("Sorted Array: ");
		quickSort.printArray(arr);
	}

	void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
