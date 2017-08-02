package leetcode.Lyft;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Created by cc on 2017/6/26.
 */
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root){
        putLeftAll(root);
    }

    public boolean hasNext(){
        return stack.isEmpty();
    }

    /**
     * This is just a iterative in order traversal.
     * keep going left and put into stack.
     * if there is no more left, pop out stack.
     * add value to result,
     * then put pop.right all left to stack.
     *
     * Any time pop out stack,
     * means that all its left subtree is done, and process itself, then process its right subtree.
     * current node is the left subtree root of the next node in stack.
     *
     * next average is O(1), because this only traverse tree once, and call next() n times will get all node in tree.
     * so each next is n/n is O(1).
     * */
    public int next(){
        TreeNode result = stack.pop();
        putLeftAll(result.right);
        return result.val;
    }

    private void putLeftAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

}
