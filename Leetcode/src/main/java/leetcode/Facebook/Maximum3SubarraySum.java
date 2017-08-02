package leetcode.Facebook;

/**
 * Created by cc on 2017/5/29.
 */
public class Maximum3SubarraySum {

    //input array nums,
    //window size is k
    //number of windows.

    //basic idea is dp.
    //O(n) extra space. n is length of array.
    //since after each loop, we can just copy current max array to previous max array.
    public int findNWindowMax(int[] nums, int k, int n){
        int[] preMax = new int[nums.length];
        int[] curMax = new int[nums.length];

        for(int i = 0; i < n; i++){
            //always k numbers sum.
            int curSum = 0;
            //starting from i+1 th section.
            for(int j = i*k; j < nums.length; j++){
                curSum += nums[j];
                //if just finish the first section.
                //make curMax = curSum + preMax[j-k].
                //Since until current j, we just have i+1 sections filled up. max is always the total sum.

                //我的这个解法才是对的！！！！！！！！！！！！！！！！！！！！
                if(j == (i+1)*k-1) curMax[j] = curSum + (j - k < 0 ? 0 : preMax[j-k]);
                //if exceeding. get current sum by exacting the first in the section.
                //then curMax[j] = max(curMax[j-1], preMax[j-k] + curSum);
                //because from j - 1 to the end, curMax already record the i+1 sections maximum.
                //we compare curMax[j-1] with preMax[j-k] + curSum. preMax record i sections maximum.
                //so preMax + curSum(current Section sum) also i+1 sections.
                if(j >= (i+1)*k){
                    //the sum from j - k + 1 to j.
                    curSum = curSum - nums[j-k];
                    curMax[j] = Math.max(curMax[j-1], preMax[j-k]+curSum);
                }
            }
            //copy curMax to preMax -- important part to use one dimention array.
            preMax = curMax;
            //reinitialize curMax to empty array. otherwise, pre and cur will point to same array, will update the same time.
            curMax = new int[nums.length];
        }
        return preMax[nums.length-1];
    }

    public static void main(String[] args) {
        int[] test = {1,2,1,2,6,7,5,1};
        Maximum3SubarraySum mas = new Maximum3SubarraySum();
        System.out.println(mas.findNWindowMax(test, 2, 3));
    }

}
