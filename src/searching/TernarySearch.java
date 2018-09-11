package searching;

public class TernarySearch {

	public int search(int[] arr, int val) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid1 = l + (r - l) / 3;
			int mid2 = mid1 + (r - l) / 3;

			if (arr[mid1] == val) {
				return mid1;
			} else if (arr[mid2] == val) {
				return mid2;
			} else if (arr[mid1] > val) {
				r = mid1 - 1;
			} else if (arr[mid2] < val) {
				l = mid2 + 1;
			} else {
				l = mid1 + 1;
				r = mid2 - 1;
			}

		}
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 7, 9, 10, 22, 23 };

		int val = 22;
		int index = new TernarySearch().search(arr, val);

		if (index != -1)
			System.out.println(val + " found at index: " + index);
		else
			System.out.println(val + " is not found!");
	}

}
