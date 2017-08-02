package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2016/4/10.
 */
public class MergeSortedList {

    public ListNode merge(ListNode l, ListNode r){

        if(l == null && r == null)
            return null;
        else if( l == null)
            return r;
        else if(r == null)
            return l;

        ListNode head = new ListNode(0);
        ListNode result = head;

        while(l != null || r != null) {

            if (l != null && r != null) {
                if (l.val <= r.val) {
                    head.next = l;
                    l = l.next;
                } else {
                    head.next = r;
                    r = r.next;
                }
            }

            else if( l == null){
                head.next = r;
                break;
            }

            else if(r == null){
                head.next = l;
                break;
            }

            head = head.next;
        }

        return result.next;
    }

}
