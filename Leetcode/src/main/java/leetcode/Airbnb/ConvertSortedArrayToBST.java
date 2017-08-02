package leetcode.Airbnb;

import leetcode.util.TreeNode;

/**
 * Created by cc on 2017/6/24.
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }

    public TreeNode convert(int[] nums, int start, int end){
        if(start == end)
            return new TreeNode(nums[start]);
        if(start > end)
            return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = convert(nums, start, mid-1);
        TreeNode right = convert(nums, mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }

}
