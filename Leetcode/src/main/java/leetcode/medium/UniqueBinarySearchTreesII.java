package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/2/21.
 */
public class UniqueBinarySearchTreesII {

    /**
     * Use each number as root,
     * get all different subTrees from left and right
     * combine them
     * */
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return genTree(1,n);
    }

    private List<TreeNode> genTree(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end){
            result.add(null);
            return result;
        }
        if(start == end){
            result.add(new TreeNode(start));
            return result;
        }
        List<TreeNode> left, right;
        //Use each i as root
        for(int i = start; i <= end; i++){
            //Get all different left and right subtrees.
            left = genTree(start, i-1);
            right = genTree(i+1, end);
            //Use i as root, combine all different combinations of left and right.
            for(TreeNode eachLeft : left){
                for(TreeNode eachRight: right){
                    TreeNode root = new TreeNode(i);
                    root.left = eachLeft;
                    root.right = eachRight;
                    //Add root to result.
                    result.add(root);
                }
            }
        }
        return result;
    }

}
