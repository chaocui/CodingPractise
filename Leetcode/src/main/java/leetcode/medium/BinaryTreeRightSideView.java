package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/2/4.
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        //Level traversal take last of each level.
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        if(root == null) return result;
        level.add(root);
        result.add(root.val);
        while(!level.isEmpty()){
            List<TreeNode> temp = new ArrayList<TreeNode>(level);
            level.clear();
            for(TreeNode each : temp){
                if(each.left != null){
                    level.add(each.left);
                }
                if(each.right != null){
                    level.add(each.right);
                }
            }
            if(level.size() != 0)
                result.add(level.get(level.size() - 1).val);
        }
        return result;
    }
}
