package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2016/4/6.
 */
public class RemoveDupFromSortedList {

    public ListNode deleteDup(ListNode head){

        ListNode current = head;
        while(current != null){
            if(current.next == null)
                return head;
            if(current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return head;
    }

}
