package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/2/7.
 */
public class RemoveDuplicatesFromSortedListII {
    //Basic idea,
    //Two pointers
    //One track the node before dup
    //One track the dup end node.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode empty = new ListNode(0);
        empty.next = head;
        //initially, slow point to dummy, fast point to head.
        //move fast if fast and fast.next value same.
        ListNode slow = empty, fast = head;
        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            //now check slow.next is fast or not,
            //if not, means fast moved. and there are dups.
            //so we delete all nodes in between. slow.next = fast.next(fast is the last dup.)
            //move fast to the next start point.
            if(slow.next != fast){
                slow.next = fast.next;
                fast = fast.next;
            }
            //otherwise, we move slow and fast both. means we keep slow, and starting point of fast is move to next also.
            else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return empty.next;
    }
}
