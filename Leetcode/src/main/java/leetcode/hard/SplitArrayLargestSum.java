package leetcode.hard;

/**
 * Created by cc on 2017/5/27.
 */
public class SplitArrayLargestSum {
    /**
     * Result is between
     * l largest number in array
     * 2 all numbers sum in array.
     * Binary search,
     * mid = l + (r-l)/2
     * for each section, make it as close to mid as possible.
     * if there are less than m groups, means we can decrease mid.
     * otherwise, we need to increase mid.
     *
     * return left, make a simple example. 1,2,3,4,5 divide into 3 groups.
     * */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for(int n : nums){
            left = Math.max(left, n);
            right += n;
        }

        while(left <= right){
            int mid = left + (right-left)/2;
            if(valid(nums,mid,m))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public boolean valid(int[] nums, int target, int m){
        //initialize count to be 1.
        //since once we found sum > target, means we are starting next group already,
        //at this time, if count > m, means we at least need m+1 groups.
        int sum = 0,count = 1;
        //Check if we can divide nums into m group that each group sum less than target.
        //less than m groups also fine. which means we need to decrease target.
        for(int n : nums){
            sum+=n;
            //exceed target, set sum to current n and increase count.
            //if count > m, means we cannot divide into m groups, target too small, need to increase.
            if(sum > target){
                sum = n;
                count++;
                if(count > m) return false;
            }
        }
        return true;
    }
}
