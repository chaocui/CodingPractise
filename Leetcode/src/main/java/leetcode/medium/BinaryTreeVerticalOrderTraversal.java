package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by cc on 2017/5/23.
 */
public class BinaryTreeVerticalOrderTraversal {
    /**
     * Basic idea,
     * while doing level order traversal,
     * not only keep track each level, also keep track of which column they sits in.
     * left child goes into col - 1, right child goes into col + 1.
     * keep track of min and max, at the end, we get result traverse each col
     * */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int min = 0, max = 0, col = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        q.add(root);
        c.add(col);
        Map<Integer, List<Integer>> track = new HashMap<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            col = c.poll();
            if(!track.containsKey(col)) track.put(col,new ArrayList<Integer>());
            track.get(col).add(node.val);

            if(node.left != null){
                q.offer(node.left);
                c.offer(col-1);
                min = Math.min(min,col-1);
            }

            if(node.right != null){
                q.offer(node.right);
                c.offer(col+1);
                max = Math.max(max, col+1);
            }
        }

        for(int i = min; i <= max; i++)
            result.add(track.get(i));
        return result;
    }
}
