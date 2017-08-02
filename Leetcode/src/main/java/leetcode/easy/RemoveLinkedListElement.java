package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/4/21.
 */
public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode h = head,pre = dummy;
        while(h != null){
            while(h != null && h.val == val) {
                remove(h, pre);
                h = pre.next;
            }
            if(h != null) {
                pre = h;
                h = h.next;
            }
        }
        return dummy.next;
    }

    private void remove(ListNode n, ListNode pre){
        if(n.next == null) {
            pre.next = null;
            n = null;
        }
        else{
            n.val = n.next.val;
            n.next = n.next.next;
        }
    }
}
