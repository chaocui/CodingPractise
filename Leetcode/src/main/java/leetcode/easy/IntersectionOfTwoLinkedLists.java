package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/4/20.
 */
public class IntersectionOfTwoLinkedLists {

    //pointing the tail to head,
    //then there is cycle.
    //Then issue becomes find the starting of the cycle in list.

    //easy proof just draw the picture.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode itA = headA, tailA = null;
        while(itA.next != null) itA = itA.next;
        itA.next = headA; tailA = itA;

        ListNode slow = headB, fast = headB;
        boolean cycle = false;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(!cycle) {
            tailA.next = null;
            return null;
        }
        slow = headB;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        tailA.next = null;
        return slow;
    }

}
