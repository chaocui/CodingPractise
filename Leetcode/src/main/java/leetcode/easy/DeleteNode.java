package leetcode.easy;

import leetcode.util.ListNode;

/**
 * Created by cc on 2016/4/4.
 */
public class DeleteNode {

    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
