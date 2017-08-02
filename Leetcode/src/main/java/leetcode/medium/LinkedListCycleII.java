package leetcode.medium;

import leetcode.util.ListNode;

public class LinkedListCycleII {
	
	//One fast, one slow.
		//when the first met. 
		//lets say slow one moves k + l
		//k is from start to cycle start.
		//l is distance on the cycle
		
		//fast one moves k + l + l + metPointToCycleStart
		//so metPointToCycleStart = k;
		//reset slow to start, move slow fast with the same speed, the meet point is the result.
	    public ListNode detectCycle(ListNode head) {
	    	ListNode slow = head, fast = head;
	    	
	    	while(fast != null && fast.next != null){
	    		slow = slow.next;
	    		fast = fast.next.next;
	    		//if they met, break;
	    		if(slow == fast) break;
	    	}
	    	
	    	//check if loop ends because of non-cycle or cycle.
	    	if(fast == null || fast.next == null) return null;
	    	
	    	slow = head;
	    	while(slow != fast){
	    		slow = slow.next;
	    		fast = fast.next;
	    	}
	    	
	    	return slow;
	    }
	
}
