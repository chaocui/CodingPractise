package leetcode.medium;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/2/13.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, current, tail;
        int i = 1;
        while(i<m){
            pre = pre.next;
            i++;
        }
        current = pre.next;
        tail = pre.next;
        while(i<=n && current!=null){
            ListNode currentNext = current.next;
            current.next = pre.next;
            pre.next = current;
            current = currentNext;
            i++;
        }
        tail.next = current;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        head.next = first;
        first.next = second;
        ReverseLinkedListII rllii = new ReverseLinkedListII();
        ListNode result = rllii.reverseBetween(head, 1,3);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
