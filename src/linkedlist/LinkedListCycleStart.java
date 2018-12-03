package linkedlist;

/*
 * Check if linked list is null terminated. If cycle is there then find start node of loop
 * 
 *							      --> 6  -- > 7 
 *                               /             \ 
 *      1 --> 2 --> 3 --> 4 --> 5 <---          \
 *                                    \          \
 *                                     8 <-- 9 <--
 *                                                      
 *                                                       
 * */

public class LinkedListCycleStart {
	public static void main(String[] args) {
		LinkedList head = new LinkedList(1, null);
		LinkedList node2 = new LinkedList(2, null);
		LinkedList node3 = new LinkedList(3, null);
		LinkedList node4 = new LinkedList(4, null);
		LinkedList node5 = new LinkedList(5, null);
		LinkedList node6 = new LinkedList(6, null);
		LinkedList node7 = new LinkedList(7, null);
		LinkedList node8 = new LinkedList(8, null);
		LinkedList node9 = new LinkedList(9, null);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node9;
		node9.next = node8;
		node8.next = node5;

		boolean isCycleExist = false;
		LinkedList fastPtr = head, slowPtr = head;
		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr) {
				isCycleExist = true;
				break;
			}

		}

		if (isCycleExist) {

			slowPtr = head;
			while (slowPtr != fastPtr) {

				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
			System.out.println("Cycle found!");
			System.out.println("Beginning of Loop: " + slowPtr.value);
		} else {
			System.out.println("No cycle!");
		}
	}

	static class LinkedList {
		int value;
		LinkedList next;

		public LinkedList(int value, LinkedList next) {
			this.value = value;
			this.next = next;
		}

		void addAtLast(int value) {
			if (this.next == null) {
				this.next = new LinkedList(value, null);
				return;
			}
			LinkedList ptr = this.next;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new LinkedList(value, null);
		}

		void addAtLast(LinkedList node) {
			if (this.next == null) {
				this.next = node;
				return;
			}
			LinkedList ptr = this.next;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = node;
		}
	}
}
