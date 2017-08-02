package Bloomberg;

import leetcode.util.TreeNode;

import java.util.HashMap;

/**
 * Created by cc on 2016/9/7.
 */
public class DFSWithPath {

    public void getPath(TreeNode root){

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode p = new TreeNode(15);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(15);

        parent.put(p.left.left, p.left);
        parent.put(p.left, p);

        System.out.println(parent.get(p.left).val);
    }




    public static void main(String[] args){
        DFSWithPath dsfwp = new DFSWithPath();
        dsfwp.getPath(null);
    }

}
