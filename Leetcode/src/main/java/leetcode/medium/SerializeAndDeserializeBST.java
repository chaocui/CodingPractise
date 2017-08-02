package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.Arrays;

/**
 * Created by cc on 2017/3/26.
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    //Need to put a separator to make sure we can deserialize each node value.
    public String serialize(TreeNode root) {
        if(root == null) return "#,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    //The first element grater than current start, is the start of right sub tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        int[] start = new int[1];
        start[0] = 0;
        return deserialize1(nodes, start);
    }

    private TreeNode deserialize1(String[] nodes, int[] start){
        if(start[0] == nodes.length) return null;
        if(nodes[start[0]].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[start[0]]));
        start[0]++;
        root.left = deserialize1(nodes,start);
        start[0]++;
        root.right = deserialize1(nodes, start);
        return root;
    }

    public static void main(String[] args) {
        Object[] test = {41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23};
        System.out.println(test.length);
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        SerializeAndDeserializeBST sadB = new SerializeAndDeserializeBST();
        System.out.print(Arrays.toString(sadB.serialize(root).toCharArray()));
        sadB.deserialize(sadB.serialize(root));


        String t = "1,2,3,4,5,";
        System.out.println(Arrays.toString(t.split(",")));
        System.out.println(t.split(",").length);
    }
}
