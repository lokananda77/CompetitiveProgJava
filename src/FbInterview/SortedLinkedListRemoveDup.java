package FbInterview;



public class SortedLinkedListRemoveDup {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	static class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	
	/*
	 * [ 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 ->
	 *  1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 
	 *  1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 ->
	 *   1 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -
	 *   > 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 
	 *   2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 
	 *   2 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 
	 *   3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 
	 *   3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 
	 *   3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 3 -> 
	 *   4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 
	 *   4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 
	 *   4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 
	 *   4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 5 -> 5
	 */
		public static ListNode deleteDuplicates(ListNode a) {
		    ListNode res = a;
		    ListNode b = a;
		    while(a.next != null && b.next != null) {
		        while(b.val == b.next.val) {
		            b = b.next;
		        }
		        a.next = b.next;
		        b = b.next;
		        a = a.next;
		    }
		    return res;
		}
		
		public static ListNode deleteDuplicates2(ListNode a) {
		    ListNode res = a;
		    ListNode b = a;
		    while(a.next != null) {
		        if(a.val != a.next.val) {
		            b.next = a.next;
		            b = b.next;
		        }
		        a = a.next;
		    }
		    b.next = null;
		    return res;
		}
		
		public static void printList(ListNode a) {
			while(a.next != null) {
				System.out.print(a.val + "->");
				a=a.next;
			}
			System.out.println(a.val + "->null");
		}
		public static void main(String[] args) {
			  ListNode e1 = new ListNode(1);
			  ListNode e2 = new ListNode(1);
			  ListNode e3 = new ListNode(1);
			  ListNode e4 = new ListNode(1);
			  ListNode e5 = new ListNode(2);
			  ListNode e6 = new ListNode(2);
			  ListNode e7 = new ListNode(2);
			  ListNode e8 = new ListNode(2);
			  ListNode e9 = new ListNode(3);
			  ListNode e10 = new ListNode(3);
			  e1.next = e2;
			  e2.next = e3;
			  e3.next = e4;
			  e4.next = e5;
			  e5.next = e6;
			  e6.next = e7;
			  e7.next = e8;
			  e8.next = e9;
			  e9.next = e10;
			  printList(e1);
			  deleteDuplicates2(e1);
			  printList(e1);
		}
	}