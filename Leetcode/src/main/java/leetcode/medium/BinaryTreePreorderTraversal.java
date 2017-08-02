package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cc on 2017/3/29.
 */
public class BinaryTreePreorderTraversal {

    /**
     * basic idea is use a stack keep track of right node of each node we visit.
     * since once this node does not have any left node, we can just go to stack top ,
     * that will be the next node we need to visit.
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> rightNode = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
            result.add(node.val);
            if(node.right != null)
                rightNode.push(node.right);
            node = node.left;
            if(node == null && !rightNode.isEmpty())
                node = rightNode.pop();
        }
        return result;
    }
}
