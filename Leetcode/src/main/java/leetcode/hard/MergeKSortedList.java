package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by cc on 2016/11/7.
 */
public class MergeKSortedList {

    //Use heap to get minimum of the k elements.
    //Fill the heap with first element in the list.
    //Then until the heap empty. get peek of heap, add to result, use pointer to get next element in the list.
    //Add to heap again.
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public class CompareListNode implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0){
            return null;
        }

        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new CompareListNode());
        for(int i = 0; i < lists.length; i++){
            ListNode each = lists[i];
            if(each!=null){
                minHeap.offer(each);
            }
        }

        ListNode root = new ListNode(0);
        ListNode current = root;
        while(!minHeap.isEmpty()){
            ListNode temp = minHeap.poll();
            if(temp.next != null){
                minHeap.add(temp.next);
            }
            temp.next = null;
            current.next = temp;
            current = current.next;
        }

        return root.next;
    }

}
