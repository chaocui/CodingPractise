package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/2/6.
 */
public class SortList {
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //break the list. otherwise will duplicate second half
        pre.next = null;
        //first half
        ListNode l = sortList(head);
        //second half
        ListNode r = sortList(slow);
        return merge(l,r);
    }

    private ListNode merge(ListNode left, ListNode right){
        //move it, keep empty point to first node.
        ListNode empty = new ListNode(0); ListNode it = empty;
        while(left != null && right != null){
            if(left.val < right.val){
                it.next = left;
                left = left.next;
            }
            else{
                it.next = right;
                right = right.next;
            }
            it = it.next;
        }
        //Basically, dont need to move any more
        //Only one of them is not null.
        //Just append the remaining list to it.
        //so use if instead of while
        if(left != null){
            it.next = left;
        }
        if(right != null){
            it.next = right;
        }
        return empty.next;
    }
}
