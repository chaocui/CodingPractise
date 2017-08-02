package leetcode.Facebook;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/5/30.
 */
public class SerializeDeserializeTree {

    //Pre order traversal to serialize, then deserialize recursively.
    public String serialize(TreeNode root){
        if(root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        String left = serialize(root.left);
        String right = serialize(root.right);
        sb.append(left).append(",").append(right);
        return sb.toString();
    }

    public TreeNode deserialize(String s){
        String[] nodes = s.split(",");
        int[] index = new int[1];
        return deserialize(nodes, index);
    }

    public TreeNode deserialize(String[] s, int[] index){
        String c = s[index[0]];
        if("#".equals(c)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(c));
        index[0]++;
        TreeNode left = deserialize(s, index);
        index[0]++;
        TreeNode right = deserialize(s, index);
        root.left = left;
        root.right = right;
        return root;
    }
}
