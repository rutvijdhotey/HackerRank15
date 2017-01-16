
package leetCode;

public class LinkedList {
	public static class Node{
		int value;
		Node next;
		
		public Node(int x){
			this.value = x;
			this.next = null;
		}
	}
	
	public static void reverseLinkedList(Node head){
		if(head == null){
			return;
		}
		
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
	
	}
	

}
