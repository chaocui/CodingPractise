package leetcode.hard;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Created by cc on 2017/3/25.
 */
public class BinarySearchTreeIterator {

    /**
     * Basic idea,
     * use a stack.
     * Initially, push root, and keep going left, push to stack.
     * this can make sure we only use O(h) space.
     *
     * then every time we pop out from stack, do the same processing for the current node's right sub tree.
     * the popped out node, which is smaller than the next one in stack,
     * also, its right sub tree is smaller than the next one too.
     * */
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = stack.pop();
        pushAll(result.right);
        return result.val;
    }

    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

}
