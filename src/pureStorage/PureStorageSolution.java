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
	
	
	public static class LinkedListNode{
		int val;
		LinkedListNode next;
		
		public LinkedListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	
	public static LinkedListNode removeNodeN(int N,LinkedListNode head){
		if(head == null){
			return null;
		} 
		LinkedListNode n = head;
		
		while(n != null){
			if(n.val == N){
				LinkedListNode temp = n.next;
				removeNode(n);
				n = temp;
			} else {
				n = n.next;
			}
		}
		
		return head;
	}
	
	
	private static void removeNode(LinkedListNode n) {
		n.val = n.next.val;
		n.next = n.next.next;
	}


	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		LinkedListNode dummy = new LinkedListNode(000);
		LinkedListNode d = new LinkedListNode(000);
		dummy.next = d;
		int N = scan.nextInt();
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			LinkedListNode node = new LinkedListNode(n);
			d.next = node;
			d= d.next;
		}
		scan.wait(10000);
		scan.close();
		LinkedListNode head = dummy.next;
		
		LinkedListNode ans = removeNodeN(N, head);
		
		while(ans.next != null){
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}
}
