package leetcode.easy;

/**
 * Created by cc on 2017/4/21.
 */
public class MergeSortedArray {
    //From right to left merge.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1, i = m - 1, j = n - 1;
        for(; i >= 0 || j >= 0;){
            //take i for sure
            //1. make sure i is still in range
            //2. either j out of range or j in range and i is greater.

            //Otherwise take j.
            if( i >= 0 && (j < 0 || nums1[i] > nums2[j])) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
    }
}
