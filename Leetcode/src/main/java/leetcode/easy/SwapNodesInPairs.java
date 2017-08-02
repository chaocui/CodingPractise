package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2016/4/10.
 */
public class SwapNodesInPairs {

    public ListNode swap(ListNode head){

        ListNode result = head;

        while(head != null && head.next != null){

            int tmp = head.val;
            head.val = head.next.val;
            head.next.val = tmp;

            head = head.next.next;
        }

        return result;
    }

}
