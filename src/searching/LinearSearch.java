package searching;

public class LinearSearch {

	public int search(int[] arr, int val) {

		for (int i = 0; i < arr.length; i++) {
			if (val == arr[i]) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 7, 9, 10, 22, 23 };

		int val = 24;
		int index = new LinearSearch().search(arr, val);

		if (index != -1)
			System.out.println(val + " found at index: " + index);
		else
			System.out.println(val + " is not found!");

	}
}
