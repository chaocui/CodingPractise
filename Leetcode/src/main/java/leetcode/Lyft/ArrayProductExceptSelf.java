package leetcode.Lyft;

/**
 * Created by cc on 2017/6/26.
 */
public class ArrayProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        //each result holds the product of all the left elements.
        for(int i = 1; i < nums.length; i++)
            result[i] = result[i-1]*nums[i-1];

        int productRight = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            result[i] = result[i]*productRight;
            productRight = productRight*nums[i];
        }

        return result;
    }
}
