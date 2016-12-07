package interview_prep;
import java.util.*;
public class RemoveDuplicates {
	public class Node {
		Node next = null;
		int value;
		Node(int value) {
			this.value = value;
		}
	}
	
	public Node insert(Node head, int val) {
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		Node n = new Node(val);
		tmp.next = n;
		n.next = null;
		return head;
	}
	
	public Node removeDup (Node head) {
		HashMap<Integer, Boolean> occ= new HashMap<Integer,Boolean>();
		Node tmp = head;
		Node tmp2 = head;
		while(tmp.next != null) {
			if (occ.get(tmp.value)) {
				tmp2.next = tmp.next;
			} else {
				occ.put(tmp.value, true);
			}
			tmp = tmp.next;
			tmp2 = tmp;
		}
		return head;
	}
	
	public static void main(String [] args) {
		
	}
}
