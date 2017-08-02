package leetcode.hard;

import java.util.Arrays;

/**
 * Created by cc on 2017/4/15.
 */
public class CreateMaximumNumber {

    /**
     * Basic idea is
     * take x from nums1 form biggest
     * take k - x from nums2 form biggest
     *
     * merge these two to get biggest, compare each other.
     * Three util function
     *
     * 1.compare two array, for this question, we need to mark the starting of comparison.
     * 2.merge, awesome, learn the awesome if statement.
     * merge of this question is different from merge sort.
     * for example 6, 7 merge 6, 0 ,4 if 6 == 6 we need to take the first 6.
     * So we compare 6, 7 and 6, 0 , 4 we take the number from the greater one. which make sure the result is greater.
     *
     * IMPORTANT PART!!! the merge is based on comparison. not like merge sort.
     *
     *
     * 3.get biggest from array tricky.
     * For each num[i] we compare with previous result,
     * if nums[i] is greater,
     * we move j back until j = 0
     * or nums[i] is smaller
     * or not enough numbers to form k
     * */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int l1 = nums1.length;
        int l2 = nums2.length;
        Arrays.fill(result, Integer.MIN_VALUE);
        //we check if there are enough numbers in l2.
        //if there is, so k - l2 is less than 0, also we can pick 0 from l1.
        //so i starting from 0
        //if not, we need at least k - l2 from l1, so i start from k - l2.
        for(int i = Math.max(0,k-l2); i <= k && i <= l1; i++){
            int[] temp1 = getNumberFromArray(nums1,i);
            int[] temp2 = getNumberFromArray(nums2,k-i);
            int[] tempResult = merge(temp1, temp2);
            result = greater(tempResult, 0, result, 0) ? tempResult : result;
        }
        return result;
    }

    //Since we comparing s1 greater than s2.
    //so if s2 reach the end, s1 is greater
    //or s1 is not reaching the end && nums1[s1] > nums2[s2]
    public boolean greater(int[] nums1, int s1, int nums2[], int s2){
        while(s1 < nums1.length && s2 < nums2.length && nums1[s1] == nums2[s2]){
            s1++;
            s2++;
        }
        return s2 == nums2.length || (s1 < nums1.length && nums1[s1] > nums2[s2]);
    }

    public int[] merge(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        for(int i = 0, j = 0, k = 0; i < nums1.length || j < nums2.length;){
            result[k++] = greater(nums1,i,nums2,j) ? nums1[i++] : nums2[j++];
        }
        return result;
    }
    /**
     * Generate maximum number has k digits from a given array.
     * order of the digits cannot be changed.
     * */
    public int[] getNumberFromArray(int[] nums, int k){
        int n = nums.length;
        int[] result = new int[k];
        //j is the index of result.
        for(int i = 0, j = 0; i < n; i++){
            /**
             * for each nums[i], we do three things
             * 1. make sure whats left is more than fill up k so that it is worth to track back.
             * 2. make sure j is > 0
             * 3. make sure result[j-1] > nums[i]
             * if not, we keep find the position j that satisfy
             */
            while(n - i + j > k && j > 0 && result[j-1] < nums[i]) j--;
            if(j < k) result[j++] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {6,7};
        int[] test2 = {6,0,4};
        int[] test3 = {6,6,7,0,4};
        int[] test4 = {6,7,6,0,4};
        CreateMaximumNumber cmn = new CreateMaximumNumber();
        int[] result = cmn.merge(test1, test2);
        System.out.println(cmn.greater(test3, 0, test4, 0));
        System.out.println();
    }
}
