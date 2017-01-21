package google;

public class MinStack {
	
	public Node head;
	public static class Node{
		int val;
		int min; 
		Node next;
		
		
		public Node(int val, int min, Node n){
			this.val = val;
			this.min = min;
			this.next = n;
			
		}
		
		public Node(int val,int min){
			this.val = val;
			this.min = min;
			this.next = null;
		}
	}
    /** initialize your data structure here. */

    public MinStack() {
    	
    }
    
    public void push(int x) {
        if(head == null){
        	head = new Node(x,x);
        } else {
        	head = new Node(x, Math.min(x, head.min),head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

}
