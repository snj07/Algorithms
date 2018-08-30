package sort;

public class BinaryTreeSort {

	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
		}
	}

	public Node insert(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		} else if (key < root.key) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.key + "  ");
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		BinaryTreeSort bts = new BinaryTreeSort();

		Node root = null;
		for (int k : arr) {
			root = bts.insert(root, k);
		}
		bts.inOrder(root);
	}
}
