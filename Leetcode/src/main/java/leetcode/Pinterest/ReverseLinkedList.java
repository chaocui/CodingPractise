package leetcode.Pinterest;

import leetcode.util.ListNode;
import leetcode.util.Utils;

/**
 * Created by cc on 2017/6/20.
 */
public class ReverseLinkedList {

    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null){
            ListNode next = head.next.next;
            head.next.next = dummy.next;
            dummy.next = head.next;
            head.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = Utils.convert(nums);
        ReverseLinkedList rll = new ReverseLinkedList();
        Utils.printList(rll.reverse(head));
    }


}
