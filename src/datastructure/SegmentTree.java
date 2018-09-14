package datastructure;

public class SegmentTree {

	public static int[] createSegmentTree(int input[]) {
		// if input len is pow of 2 then size of
		// segment tree is 2*len - 1, otherwise
		// size of segment tree is next (pow of 2 for len)*2 - 1.
		int nextPowOfTwo = nextPowerOf2(input.length);
		int segmentTree[] = new int[nextPowOfTwo * 2 - 1];

		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}
		constructMinSegmentTree(input, segmentTree, 0, input.length - 1, 0);
		return segmentTree;

	}

	public static void constructMinSegmentTree(int[] input, int[] segTree, int low, int high, int pos) {
		if (low == high) {
			segTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		constructMinSegmentTree(input, segTree, low, mid, 2 * pos + 1);
		constructMinSegmentTree(input, segTree, mid + 1, high, 2 * pos + 2);
		segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
	}

	public static int rangeMinQuery(int[] segTree, int qLow, int qHigh, int low, int high, int pos) {

		if (qLow <= low && qHigh >= high) { // total overlap
			return segTree[pos];
		} else if (qLow > high || qHigh < low) { // no overlap
			return Integer.MAX_VALUE;
		}
		int mid = (low + high) / 2;
		return Math.min(rangeMinQuery(segTree, qLow, qHigh, low, mid, 2 * pos + 1),
				rangeMinQuery(segTree, qLow, qHigh, mid + 1, high, 2 * pos - 1));

	}

	public static int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	public static void main(String[] args) {

		int input[] = { 0, 3, 4, 2, 1, 6, -1 };
		int segTree[] = createSegmentTree(input);

		assert 0 == rangeMinQuery(segTree, 0, 3, 0, input.length - 1, 0);
		assert 1 == rangeMinQuery(segTree, 1, 5, 0, input.length - 1, 0);
		assert -1 == rangeMinQuery(segTree, 1, 6, 0, input.length - 1, 0);
	}
}
