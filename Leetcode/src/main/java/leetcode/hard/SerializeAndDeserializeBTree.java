package leetcode.hard;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2016/11/9.
 */
public class SerializeAndDeserializeBTree {

    //Pre order traverse
    //Each null print out as #
    //Serialize is simple, use stringbuilder to append root, left, right, since there might be negtive number, use delimeter.
    public String serialize(TreeNode root){
        if(root == null){
            return "#,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    //Deserialize needs a helper since data as parameter, we cannot track where we are now.
    //In order to track that,
    //we need to pass in a array(or a reference to obj), so the value will be changed in each recursive call and available to all calls.
    public TreeNode deSerialize(String data){

        String[] nodes = data.split(",");
        int[] start = new int[1];
        start[0] = 0;
        return deSerialize1(nodes, start);
    }

    public TreeNode deSerialize1(String[] nodes, int[] start){
        //if reach the end, we return null
        if(start[0] == nodes.length){
            return null;
        }
        //if reach #, also returns null,
        if(nodes[start[0]].equals("#")){
            return null;
        }
        //Then process root, move 1 step forward(change value of array element to effect all)
        TreeNode root = new TreeNode(Integer.parseInt(nodes[start[0]]));
        start[0]++;
        root.left = deSerialize1(nodes, start);
        //After process left, move forward.
        start[0]++;
        root.right = deSerialize1(nodes,start);
        return root;
    }

    public static void main(String[] args){
        SerializeAndDeserializeBTree sad = new SerializeAndDeserializeBTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(6);
        TreeNode right = new TreeNode(8);
        left.left = leftLeft;
        root.left = left;
        root.right = right;
        System.out.println(sad.serialize(root));
        sad.deSerialize(sad.serialize(root));
    }
}
