package leetcode.hard;

/**
 * Created by cc on 2017/4/17.
 */
public class CountOfRangeSum {

    /**
     * Count smaller number after itself.
     * we use merge sort to count num[j] < num[i], i is left side, j is right side.
     * basic idea is:
     * 1. if num[j] < num[i], we increase count, also increase j.
     * 2. if num[j] >= num[i], we add count to result, increase i.
     *
     * basically, if nums[i]<=nums[j], the count for previous i also applys to current i. because current num[i]
     * is greater than previous num[i].
     *
     *
     * Basically, we can get from i to j(exclusive) sum in O(N) by having an array holding sum from 0 to i(exclusive)
     *
     * Then same idea we sort the sum.
     * what we need to get is the index k that sum[k] - sum[i] >= lower,
     * also we need to find the index j that sum[j] - sum[i] > upper.
     * So that from i to any index that between k and j are part of the result
     * so that j - k is the current result of i.
     * then we merge, we accumulate result.
     *
     * */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] sum = new long[len+1];
        for(int i = 0; i < len; i++)
            sum[i+1] = sum[i] + nums[i];

        //end is len+1 so its exclusive
        return countWhileMergeSort(sum, 0, len+1, lower, upper);
    }

    //end is exclusive
    private int countWhileMergeSort(long[] sum, int start, int end, int lower, int upper){
        if(end - start <= 1) return 0;
        int mid = (start + end)/2;
        int count = countWhileMergeSort(sum, start, mid, lower, upper)+countWhileMergeSort(sum, mid, end, lower, upper);

        int k = mid, j = mid, m = mid;
        long[] cache = new long[end - start];
        //find the position of j , k
        //and do merge sort, if right side is small, assign right side to temp array, and move right side.
        //once break, we assign left side.
        //after done, the final m position is final position of this temp array.
        //the acutal number of value we have merge is m - start. then we copy temp to sum.
        for(int i = start, r = 0; i < mid; i++, r++) {
            while (j < end && sum[j] - sum[i] <= upper) j++;
            while (k < end && sum[k] - sum[i] < lower) k++;
            while (m < end && sum[m] < sum[i]) cache[r++] = sum[m++];
            cache[r] = sum[i];
            count += j - k;
        }

        System.arraycopy(cache, 0, sum, start, m-start);
        return count;
    }

}
