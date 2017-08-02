package leetcode.Snapchat;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/18.
 */
public class FindModeInBinarySearchTree {

    /**
     * The reason why we use inorder traversal is because
     * in-order traverse of BST, the result is sorted.
     * So that we won't skill the same number.
     * */
    List<Integer> result = new ArrayList<>();
    int currentVal;
    int currentCount;
    int maxCount;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            r[i] = result.get(i);
        return r;
    }

    public void processValue(int val){
        if(val != currentVal){
            currentCount = 0;
            currentVal = val;
        }
        currentCount++;
        if(currentCount > maxCount){
            maxCount = currentCount;
            result.clear();
            result.add(currentVal);
        }
        else if(currentCount == maxCount)
            result.add(currentVal);
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        processValue(root.val);
        inorder(root.right);
    }

}
