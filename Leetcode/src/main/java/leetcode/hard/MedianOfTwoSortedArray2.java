package leetcode.hard;

/**
 * Created by cc on 2017/4/11.
 */
public class MedianOfTwoSortedArray2 {

    /**
     * This question can be generalized to find kth elements in two sorted array.
     *
     * find kth elements in two sorted array.
     * 1. find k/2th element in two arrays.
     * 2. compare them.
     * 3. the smaller one abandon all the left elements.
     * The reason being: since its k/2th element is smaller, the k/2th element can be most k-1th element.
     * so all the left elements has no chance to be kth element.
     * 4 recursively do this.
     *
     * base case:
     * start >= length for both array, just return the kth in the other array.
     * if k == 1, just compare start element of both array. return the smaller one
     *
     * */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        if(length%2 == 1) return findKthElement(nums1, 0, nums2, 0, length/2+1);
        else return (findKthElement(nums1,0,nums2,0,length/2 + 1) + findKthElement(nums1,0,nums2,0,length/2))/2.0;
    }


    /**
     * Find kth elements,
     * find the median can be generalize to find kth element.
     *
     * k indicates the kth element,
     * so when we calculate index, we need to -1.
     * */

    public int findKthElement(int[] a, int aStart, int[] b, int bStart, int k){
        if(aStart >= a.length)
            return b[bStart + k - 1];
        if(bStart >= b.length)
            return a[aStart + k - 1];
        if(k == 1)
            return Math.min(a[aStart], b[bStart]);

        int halfKthIndexIna = aStart + k/2 - 1;
        int halfKthIndexInb = bStart + k/2 - 1;

        int k2A = halfKthIndexIna < a.length ? a[halfKthIndexIna] : Integer.MAX_VALUE;
        int k2B = halfKthIndexInb < b.length ? b[halfKthIndexInb] : Integer.MAX_VALUE;

        //abandon a's left
        //Since, we take k/2 from both a and b, so if a is less than b,
        //a is at most k-1, so a's left has no chance to be the kth. just abandon them.
        if(k2A < k2B) return findKthElement(a, aStart + k/2, b, bStart, k - k/2);
        //same reason abandon b's left.
        else return findKthElement(a, aStart, b, bStart + k/2, k - k/2);
    }
}
