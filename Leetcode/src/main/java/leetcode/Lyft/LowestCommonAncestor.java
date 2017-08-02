package leetcode.Lyft;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by cc on 2017/6/26.
 */
public class LowestCommonAncestor {

    /**
     * Recursive way,
     * if root == null || root == p || root == q, means we find either p or q, we just return.
     * otherwise, we recursive do left and right.
     * if left find nothing, must return right result.
     * vice-versa,
     * if left and right both find result, then we return root, because, left and right contains either q or p,
     * so root is the lowest common.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    //iterative way
    /**
     * Basic idea,
     * keep track of parent of each node.
     * Then from p we chase back, add all ancestor to set.
     * then from q we chase back, set q = q.parent, until we find q in set, thats the result.
     * */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!parents.containsKey(p) || !parents.containsKey(q)){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    parents.put(node.left, node);
                }
                if(node.right != null){
                    queue.add(node.right);
                    parents.put(node.right, node);
                }
            }
        }
        Set<TreeNode> ancestor = new HashSet<>();
        //add all p's ancestor until root node.
        while(p != null){
            ancestor.add(p);
            p = parents.get(p);
        }
        //keep finding q's ancestor, until the first one in ancestor.
        while(!ancestor.contains(q))
            q = parents.get(q);

        return q;
    }
}