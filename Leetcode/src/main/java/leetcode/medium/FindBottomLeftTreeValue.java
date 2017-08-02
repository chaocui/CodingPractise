package leetcode.medium;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2017/4/3.
 */
public class FindBottomLeftTreeValue {

    //Level order traversal
    //Use queue to traverse, so much clean and easy.
    //basic idea is before we get anything from queue.
    //we get the length of the queue, which is the number of nodes of the previous level.
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0) result = node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

}
