package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cc on 2017/3/29.
 */
public class BinaryTreeInorderTraversal {
    //Keep adding left until left is null
    //pop out left and add to result.
    //add left.right to stack.
    //keep doing the same thing.
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            TreeNode n = stack.pop();
            result.add(n.val);
            node = n.right;
        }
        return result;
    }
}
