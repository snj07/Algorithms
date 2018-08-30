package sort;

public class HeapSort {

	public void sort(int[] arr) {
		int n = arr.length;
		
		//create heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			// move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//max heapify on reduced heap
			heapify(arr, i, 0);
		}
	}

	public void heapify(int[] arr, int size, int root) {

		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != root) {
			int temp = arr[root];
			arr[root] = arr[largest];
			arr[largest] = temp;
			// heapify subtree
			heapify(arr, size, largest);
		}

	}

	public static void main(String[] args) {

		int[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		HeapSort heapSort = new HeapSort();
		System.out.println("Array: ");
		heapSort.printArray(arr);
		heapSort.sort(arr);
		System.out.println("Sorted Array: ");
		heapSort.printArray(arr);
	}

	public void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
