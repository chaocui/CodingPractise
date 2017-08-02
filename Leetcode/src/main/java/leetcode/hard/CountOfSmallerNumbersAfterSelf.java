package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2016/12/4.
 */
/**
 *  Basic idea,
 *  Use BST
 *  loop through from right to left.
 *  for each node, we hold duplication, left side count. Left side count means numbers smaller than current.
 *
 *  we insert elements in array from right to left.
 *  for each insertion,
 *  1. If we go right, means current node.dupCount + node.leftCount are smaller than current value we are inserting.
 *     so, each time we go right, we add them together.
 *     we add recursion return + root.leftCount + root.dupCount.
 *     We go right, nothing need to be update.
 *  2. If we go left, count = what ever returned from recursion
 *     we go left, we update leftCount
 *  3. If we found same, count = root.leftCount;
 *     we found same, we update dupCount.
 *
 * */
public class CountOfSmallerNumbersAfterSelf {
    public class TreeNode{
        TreeNode left = null;
        TreeNode right = null;
        int dupCount = 0;
        int leftCount = 0;
        int val = 0;
    }
    public class NodeAndCount{
        TreeNode node;
        int count;
    }
    public NodeAndCount insert(TreeNode root, int val){
        if(root == null){
            TreeNode result = new TreeNode();
            result.val = val;
            result.dupCount = 1;
            NodeAndCount nac = new NodeAndCount();
            nac.count = 0;
            nac.node = result;
            return nac;
        }
        //Go right
        int count = 0;
        if(val > root.val){
            NodeAndCount temp = insert(root.right, val);
            root.right = temp.node;
            count = temp.count + root.dupCount + root.leftCount;
        }
        //Go left
        else if(val < root.val){
            NodeAndCount temp = insert(root.left, val);
            root.left = temp.node;
            root.leftCount ++;
            count = temp.count;
        }
        else if(val == root.val){
            root.dupCount ++;
            count = root.leftCount;
        }
        NodeAndCount res = new NodeAndCount();
        res.node = root;
        res.count = count;
        return res;
    }
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return new ArrayList<Integer>();
        }
        Integer result[] =  new Integer[len];
        result[len-1] = 0;
        TreeNode root = new TreeNode();
        root.val = nums[len-1];
        root.dupCount = 1;
        for(int i = len-2; i >=0; i--){
            NodeAndCount nac = insert(root,nums[i]);
            result[i] = nac.count;
        }
        return new ArrayList<Integer>(Arrays.asList(result));
    }
    public static void main(String[] args){

    }
}
