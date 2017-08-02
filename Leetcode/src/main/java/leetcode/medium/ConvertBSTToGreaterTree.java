package leetcode.medium;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/4/5.
 */
public class ConvertBSTToGreaterTree {


    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        getResult(root, sum);
        return root;
    }

    private void getResult(TreeNode node, int[] sum){
        if(node == null) return;
        getResult(node.right, sum);
        node.val += sum[0];
        sum[0] = node.val;
        getResult(node.left, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;
        ConvertBSTToGreaterTree cbsttgt = new ConvertBSTToGreaterTree();
        cbsttgt.convertBST(root);
        System.out.println();
    }
}
