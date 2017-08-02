package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/4/7.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(l1 != null && l2 != null){
            ListNode newNode = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            ListNode newNode = new ListNode((l1.val + carry)%10);
            carry = (l1.val + carry)/10;
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode newNode = new ListNode((l2.val + carry)%10);
            carry = (l2.val + carry)/10;
            current.next = newNode;
            current = current.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        return dummy.next;
    }

}
