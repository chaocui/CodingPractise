package leetcode.medium;

import leetcode.util.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode fast = dummy, slow = dummy;
    	int count = 0;
    	//move fast pointer n steps before slow.
    	//Since fast was initialized at dummy, 
    	//n is always valid. so fast can move to the end of the list at most. fast wont be null during first loop
    	while(count < n){ 
    		fast = fast.next;
    		count ++;
    	}
    	//keep track of slow's previous node.
    	//then we remove slow
    	ListNode pre = dummy;
    	while(fast != null){
    		pre = slow;
    		fast = fast.next;
    		slow = slow.next;
    	}

    	pre.next = slow.next;
    	slow.next = null;
    	
    	return dummy.next;
    }
}
