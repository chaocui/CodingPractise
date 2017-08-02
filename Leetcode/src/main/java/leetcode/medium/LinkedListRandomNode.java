package leetcode.medium;

import leetcode.util.ListNode;

import java.util.Random;

/**
 * Created by cc on 2017/4/5.
 */
public class LinkedListRandomNode {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */

    ListNode head = null;
    Random r = null;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        r = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = head.val;
        ListNode it = head;
        for(int i = 1; it.next != null; i++){
            it = it.next;
            //bound is exclusive. so value will be 0 to i;
            /**
             * basic idea:
             * for every value, the possibility of choosing it based on random function is 1/i;
             * for all previous value, choosing them possibility now is (i-1)/i.
             * each of the previous value has been chosen, the possibility is 1/(i-1).
             * So now all the previous value been chosen, possibility is sitll 1/(i-1) * (i-1)/i = 1/i
             * */
            if(r.nextInt(i+1) == i)
                result = it.val;
        }
        return result;
    }

}
