package datastructure;

public class TrieDemo {

	static final int SIZE = 26;
	static TrieNode root;

	static class TrieNode {
		TrieNode[] children = new TrieNode[SIZE];
		boolean isEndOfWord;
	}

	public static void insert(String word) {
		TrieNode tNode = root;
		int len = word.length();
		int index;
		for (int i = 0; i < len; i++) {
			index = word.charAt(i) - 'a';
			if (tNode.children[index] == null) {
				tNode.children[index] = new TrieNode();
			}
			tNode = tNode.children[index];
		}
		tNode.isEndOfWord = true;
	}

	public static boolean searchWord(String word) {
		TrieNode tNode = root;
		int len = word.length();
		int index;
		for (int i = 0; i < len; i++) {
			index = word.charAt(i) - 'a';
			if (tNode.children[index] == null) {
				return false;
			}
			tNode = tNode.children[index];
		}
		if (tNode.isEndOfWord) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		root = new TrieNode();
		String[] arr = {"ab","abgl","cdf","abcd","lmn"};
		String wordToFind = arr[2];
		for (String s : arr) {
			insert(s);
		}
		if(searchWord(wordToFind)) {
			System.out.println("Found!");
		}else {
			System.out.println("Not Found!");
		}
		
	}

}
