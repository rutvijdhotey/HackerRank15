package google;

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedLIstRandomNode {
    
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	
	HashMap<Integer,ListNode> map;
	
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedLIstRandomNode(ListNode head) {
        map = new HashMap<>();
        ListNode n = head;
        int count = 0;
        while(n != null){
        	map.put(count, n);
        	count++;
        	n = n.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int random = (int) Math.random() * (0 - map.size() - 1);
        int n = map.get(random).val;
        
        return n;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
