package leetcode.Snapchat;

import leetcode.medium.ComplexNumberMultiplication;

/**
 * Created by cc on 2017/6/17.
 */
public class Computable {

    /**
     * always loop from 0 to nums.length,
     * use a extra array keep track of which is used.
     *
     * Back tracing
     *
     * */
    public boolean computable(int[] nums, int target){
        boolean[] used = new boolean[nums.length];
        return getResult(nums, target, used, 0);
    }

    public boolean getResult(int[] nums, int target, boolean[] used, int count){
        if(target <= 0 && count < nums.length)
            return false;
        if(count == nums.length){
            if(target == 0) {
                return true;
            }
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i]=true;
            boolean r1 = getResult(nums, target - nums[i], used, count+1);
            boolean r2 = false;
            if(target%nums[i] == 0){
                r2 = getResult(nums, target/nums[i], used, count+1);
            }
            if(r1 || r2)
                return true;
            used[i]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        Computable c = new Computable();
        int[] test = {1,2,3};
        System.out.println(c.computable(test, 80));
    }
}
