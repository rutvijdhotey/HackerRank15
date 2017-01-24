package pureStorage;

import java.util.Scanner;

public class PureStorageSolution {

	public static int func(int n){
		if (n == 4){
			return 2;
		} else {
			return 2 * func(n+1);
		}
	}
	
	
	public static class LinkedListLinkedListNode{
		int val;
		LinkedListLinkedListNode next;
		
		public LinkedListLinkedListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	
	public static LinkedListLinkedListNode removeLinkedListNodeN(int N,LinkedListLinkedListNode head){
		if(head == null){
			return null;
		} 
		LinkedListLinkedListNode n = head;
		
		while(n != null){
			if(n.val == N){
				LinkedListLinkedListNode temp = n.next;
				removeLinkedListNode(n);
				n = temp;
			} else {
				n = n.next;
			}
		}
		
		return head;
	}
	
	
	private static void removeLinkedListNode(LinkedListLinkedListNode n) {
		n.val = n.next.val;
		n.next = n.next.next;
	}


	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		//LinkedListLinkedListNode dummy = new LinkedListLinkedListNode(000);
		//LinkedListLinkedListNode d = new LinkedListLinkedListNode(000);
		//dummy.next = d;
		int N = scan.nextInt();
		while(scan.hasNextInt()){
			//int n = scan.nextInt();
			//LinkedListLinkedListNode LinkedListNode = new LinkedListLinkedListNode(n);
			//d.next = LinkedListNode;
			//d= d.next;
		}
		//scan.wait(10000);
		scan.close();
		LinkedListNode head = dummy.next;
	
		while(dummy.next != null){
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}
	
	
	
	
	if (head != null)
    {
        
    }
	
	
	
	
}
