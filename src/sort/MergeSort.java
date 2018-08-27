package sort;

public class MergeSort {
	void sort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}

	}

	public void merge(int[] arr, int left, int mid, int right) {

		int i = left;
		int j = mid;
		int k = mid;
		int l = right;
		int current = 0;
		int[] temp = new int[right - left];

		while (i < j && k < l) {
			if (arr[i] < arr[k]) {
				temp[current++] = arr[i++];
			} else {
				temp[current++] = arr[k++];
			}
		}
		while (i < j) {
			temp[current++] = arr[i++];
		}
		while (k < l) {
			temp[current++] = arr[k++];
		}
		for (int x = left, cur = 0; x < right; ++x, ++cur) {
			arr[x] = temp[cur];
		}
	}

	// Driver program
	public static void main(String[] args) {

		int[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		MergeSort mergeSort = new MergeSort();
		System.out.println("Array: ");
		mergeSort.printArray(arr);
		mergeSort.sort(arr, 0, arr.length);
		System.out.println("Sorted Array: ");
		mergeSort.printArray(arr);
	}

	 void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
