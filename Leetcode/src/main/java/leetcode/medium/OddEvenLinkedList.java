package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2016/8/7.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode result = head;
        ListNode oddEnd = head;
        ListNode evenStart = head.next;
        ListNode evenEnd = head.next;

        while(evenEnd != null && evenEnd.next != null){

            ListNode current = evenEnd.next;
            oddEnd.next = current;
            oddEnd = oddEnd.next;
            evenEnd.next = current.next;
            evenEnd = evenEnd.next;
            current.next = evenStart;
        }
        return result;
    }

}
