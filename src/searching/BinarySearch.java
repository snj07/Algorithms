package searching;

public class BinarySearch {

	public int search(int[] arr, int val) {

		int i = 0;
		int j = arr.length - 1;
		int m = (i + j) / 2;
		while (i <= j) {
			if (arr[m] == val) {
				return m;
			} else if (arr[m] > val) {
				j = m - 1;
			} else {
				i = m + 1;
			}
			m = (i + j) / 2;
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 7, 9, 10, 22, 23 };

		int val = 24;
		int index = new BinarySearch().search(arr, val);

		if (index != -1)
			System.out.println(val + " found at index: " + index);
		else
			System.out.println(val + " is not found!");

	}
}
