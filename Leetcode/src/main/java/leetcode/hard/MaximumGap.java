package leetcode.hard;

import java.util.Arrays;

/**
 * Created by cc on 2017/4/15.
 */
public class MaximumGap {

    /**
     *
     * MaximumGap, bucket sort.
     * Bucket sort!!! 十分不熟... 不会第一时间反映出是 桶排
     *
     * 1. the maximum gap cannot be less than (max-min)/(num.length-1）
     * Because, lets assume it distributed evenly, the gap will be (max-min)/(num.length-1）
     * if not even, so must be some gap smaller, some bigger. so at least (max-min)/(num.length-1）.
     *
     * 2. we have length of num.length-1 buckets.
     * bucket gap is (max-min)/(num.length-1）.
     * So the largest gap cannot in the same bucket.
     *
     * 3. We keep bucket min and max, min - previous max will be the max.
     * loop through all bucket to get the max.
     *
     * since there are n-2 numbers, n-1 buckets, at least one bucket is empty.
     * */
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int length = nums.length;

        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        //find the bucket size.
        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));
        //store min for each bucket.
        //store max for each bucekt.
        int[] bucketMin = new int[nums.length-1];
        int[] bucketMax = new int[nums.length-1];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for(int n : nums){
            //find the index in the bucket.
            if(n == min || n == max) continue;
            int i = (n-min)/gap;
            bucketMin[i] = Math.min(bucketMin[i], n);
            bucketMax[i] = Math.max(bucketMax[i], n);
        }

        //since we don't put min and max into bucket.
        //start pre as min, and finally we count max
        int pre = min;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < bucketMin.length; i++){
            //bucket is empty, skip
            if(bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            result = Math.max(bucketMin[i] - pre, result);
            //since we use min - previousMax keep updating pre as previous max
            pre = bucketMax[i];
        }
        result = Math.max(result, max - pre);
        return result;
    }

}
