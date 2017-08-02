package leetcode.easy;

import leetcode.util.Utils;
import leetcode.util.ListNode;

/**
 * Created by cc on 2017/4/21.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head, fast = head;
        //First part need to notice.
        //while find middle of the list.
        //fast != null && fast.next !=null

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Once loop done, have a simple example figure out what the relation between slow and fast.
        //where is second half start, basically.

        //If fast == null, means its even numbers of nodes
        //if fast.next == null, means odd numbers of nodes

        /**
         * Just give two examples we can figure out where slow end up with.
         *
         * 1. 1,2,3,4,5 : slow end up at 3, and fast is at 5.
         * 2. 1,2,3,4 : slow end up at 3, and fast is at null.
         *
         * So if fast is null, second half starts at slow.
         * if fast.next is null, second half starts at slow.next.
         * */
        ListNode first = head, second = slow.next;
        if(fast == null) second = slow;

        //Second part need to notice is
        //When we reverse the list.
        //we just keep track of the tail, which is the head.
        //then pointing tail to current.next.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        while(first != slow){
            ListNode next = first.next;
            first.next= dummy.next;
            dummy.next = first;
            tail.next = next;
            first = next;
        }
        first = dummy.next;
        tail = dummy.next;
        //This part just compare and reverse back.
        boolean result = true;
        while(second != null){
            if(first.val != second.val)
                result = false;
            ListNode next = first.next;
            first.next= dummy.next;
            dummy.next = first;
            tail.next = next;
            first = next;
            second = second.next;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,2,1,2,1,1};
        ListNode head = Utils.convert(test);
        PalindromeLinkedList pll = new PalindromeLinkedList();
        System.out.println(pll.isPalindrome(head));
    }

}
