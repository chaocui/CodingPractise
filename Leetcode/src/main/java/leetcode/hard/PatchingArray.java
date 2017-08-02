package leetcode.hard;

/**
 * Created by cc on 2016/11/9.
 */
public class PatchingArray {
    //https://discuss.leetcode.com/topic/35494/solution-explanation
    //This guy is a genius.
    //assume we can get [1,miss), so if the next number in nums is <= miss,
    //means include this number we can expand our range to [1,miss+num[i]),
    //If next num > miss, we cannot simple include this number since we will never construct miss to this number.
    //So we try to be greedy, we expand to the maximum we can expand which is miss.
    //so we add miss to miss [1, miss*2)
    public int minPatches(int[] nums, int n) {
        int result = 0, i = 0;
        long miss = 1;
        //since we need to include n in the result,
        //so even miss = n, we still need one more loop
        while(miss <= n){
            //If still has more elements in array && element in array is less than or equal to miss.
            //expand range, move to next element in array.
            if(i < nums.length && miss >= nums[i]){
                miss += nums[i];
                i++;
            }
            //If no more elements in array or miss < elements in array.
            //We add miss to the result,
            //add 1 to result. means to need to patch one in the array to make it happen.
            else{
                miss += miss;
                result++;
            }
        }
        return result;
    }

}
