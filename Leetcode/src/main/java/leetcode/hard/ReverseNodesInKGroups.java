package leetcode.hard;

import leetcode.util.ListNode;

/**
 * Created by cc on 2017/5/25.
 */
public class ReverseNodesInKGroups {

    /**
     * Reverse every k node, then if the last couple nodes is not k, reverse it back.
     *
     * How to do it.
     * head -> start of each section
     * move start -> next to after head k - 1 times
     * start point to start next,
     * head point to start.
     * Do it again.
     *
     * Every section, track how nodes we moved, if its less than k - 1, we reverse it back.
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail =  dummy;

        while(true){
            int count = k;
            while(count > 0 && tail != null){
                tail = tail.next;
                count--;
            }
            if(tail == null) break;

            //before reverse, pointing head to the interval start.
            //so that after reverse, head will pointing to tail
            //which is the pre of next section.
            head = pre.next;
            while(pre.next != tail){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            pre = head;
            tail = head;
        }
        return dummy.next;
    }

}
