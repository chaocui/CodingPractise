package leetcode.Facebook;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cc on 2017/6/4.
 */
public class PreorderTraversal {

    public List<Integer> traverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null){
            //basically, before we going left.
            //keep track of right path we need to go.
            //once left is done, we take out from stack and traverse.
            result.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            node = node.left;
            if(node == null && !stack.isEmpty())
                node = stack.pop();
        }
        return result;
    }
}
