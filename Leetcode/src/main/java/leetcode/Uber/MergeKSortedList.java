package leetcode.Uber;

import leetcode.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/6/15.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode n : lists) {
            if (n != null)
                minHeap.offer(n);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!minHeap.isEmpty()){
            ListNode n = minHeap.poll();
            current.next = n;
            if(n.next != null)
                minHeap.offer(n.next);
            current = current.next;
        }
        return dummy.next;
    }
}
