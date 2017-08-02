package leetcode.medium;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/3/8.
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return getResult(head, null);
    }

    private TreeNode getResult(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        TreeNode left = getResult(head,slow);
        TreeNode right = getResult(slow.next, tail);
        root.left = left;
        root.right = right;

        return root;

    }

    //Why does this has ETL
    public TreeNode sortedListToBSTII(ListNode start) {
        if (start == null) return null;
        if (start.next == null) return new TreeNode(start.val);

        ListNode slow = start, fast = start, pre = start;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightStart = slow.next;
        TreeNode root = new TreeNode(slow.val);
        pre.next = null; //cut the list

        TreeNode left = sortedListToBST(start);
        TreeNode right = sortedListToBST(rightStart);
        root.left = left;
        root.right = right;

        return root;
    }
}

