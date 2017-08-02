package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/3/6.
 *
 * This is basically the most difficult linked list issue.
 *
 * rotate, reverse, and insert. including all operations in one issue.
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //end1 marks the end of the first half.
        //current is the iterator of second half.
        ListNode end1 = slow; ListNode current = slow.next;
        //basically, keep current fixed
        //move currentNext after end1.
        while(current.next != null){
            ListNode currentNext = current.next;
            current.next = currentNext.next;
            currentNext.next = end1.next;
            end1.next = currentNext;
        }
        //Keep end1 not moving, head not moving.
        //loop until headIt reach end1
        current = slow.next;
        ListNode headIt = head;
        while(headIt != slow){
            //mark end1 pointing to next node needs to be moved.
            slow.next = current.next;
            //move current after headIt.
            current.next = headIt.next;
            headIt.next = current;
            //move head it to next node which we need to insert after
            headIt = current.next;
            //move current to next node need to be moved.
            current = slow.next;
        }
    }
}
