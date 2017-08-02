package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2016/4/6.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode pre = null;
        while(current != null){
            ListNode tempNext = current.next;
            current.next = pre;
            pre = current;
            current = tempNext;
        }
        return pre;
    }

}
