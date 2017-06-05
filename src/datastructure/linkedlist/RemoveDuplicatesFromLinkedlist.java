package datastructure.linkedlist;

import java.util.Hashtable;

/*
 *  Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicatesFromLinkedlist {

	// If we can use a buffer, we can keep track of elements in a hashtable and
	// remove any duplicates
	public static void deleteduplicates(Node head) {
		if (head == null)
			return;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node n = head;
		Node previous = null;// �?存处�?�中的当�?�?置，下一个�?置�?�以放入下一个�?�?�?的数字
		while (n != null) {

			if (!table.containsKey(n.data))// 如果节点的值�?在表中
			{
				table.put(n.data, true);// 数值放入表中
				previous = n;
			}

			else // 如果节点的值在表中
			{
				previous.next = n.next;//把当�?节点去掉
			}

			n = n.next;
		}
		// return head;//直接就改�?�了原�?�的值，所以�?返回head也行
	}

	/*
	 * Without a buffer, we can iterate with two pointers: “current�? does a
	 * normal iteration, while “runner�? iterates through all prior nodes to
	 * check for duplicates. Runner will only see one duplicate per node, because if there
	 * were multiple duplicates they would have been removed already
	 */

	public static void deleteduplicates2(Node head) {
		if (head == null)
			return;
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			Node runner = head;
			while (runner != current) { // Check for earlier duplicates
				if (runner.data == current.data) {
					Node tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other duplicates have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated �? update now
				previous = current;
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(1);
		Node d = new Node(2);
		Node e = new Node(3);
		Node f = new Node(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		Node n = a;
		System.out.println("BEFORE: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

		deleteduplicates2(a);

		System.out.println("\nAFTER: ");
		n = a;
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

	}
}
