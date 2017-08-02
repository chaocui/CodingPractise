package leetcode.hard;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by cc on 2016/11/13.
 */
public class BinaryTreePostOrderTraversal {

    //Stack
    //Use extra space.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new LinkedList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.peek();
            if(tempNode.left != null && !visited.contains(tempNode.left)){
                stack.push(tempNode.left);
            }
            else if(tempNode.right != null && !visited.contains(tempNode.right)){
                stack.push(tempNode.right);
            }
            else{
                stack.pop();
                result.add(tempNode.val);
                visited.add(tempNode);
            }
        }
        return result;
    }

    //No extra space.
    //Use pre to mark previous visited.
    //check current and pre relation to see if it go up or down.
    public List<Integer> postTraversal(TreeNode root){

        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        TreeNode pre = null;
        TreeNode current = null;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            current = stack.peek();
            //Traverse down
            if(pre == null || pre.left == current || pre.right == current){
                if(current.left != null){
                    stack.push(current.left);
                }
                else if(current.right != null){
                    stack.push(current.right);
                }
            }
            //Traverse up from left.
            else if(pre == current.left){
                //Done with left, check right.
                if(current.right != null){
                    stack.push(current.right);
                }
            }
            //else{ dont have to check, if not satisfy previous conditions, just print out.}
            //case 1:
            //node has no more child, pre == current, print out
            //case 2:
            //pre == current.right. means from right go up, print out.
            else{
                result.add(current.val);
                stack.pop();
            }
            pre = current;
        }
        return result;
    }

}
