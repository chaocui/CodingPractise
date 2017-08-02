package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/1/25.
 */
public class FindKPairswithSmallestSums {

    public class Pair{
        int first, second;
        long sum;
        public Pair(int firstIndex, int secondIndex, long sum){
            this.first = firstIndex;
            this.second = secondIndex;
            this.sum = sum;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return result;

        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o1.sum, o2.sum);
            }
        });
        for(int i = 0; i < nums1.length && i < k; i++){
            heap.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        //important part is
        //check heap is empty or not.
        //if k is greater than nums1.length*nums2.length, return all combinations.
        //so heap is possible empty. but i is still less than k.
        //SO WE NEED TO CHECK HEAP IS EMPTY.
        for(int i = 0; i < k && !heap.isEmpty(); i++){
            Pair p = heap.poll();
            int[] each = {nums1[p.first], nums2[p.second]};
            result.add(each);
            int nextIndex = p.second+1;
            if(nextIndex < nums2.length) {
                Pair newP = new Pair(p.first, p.second + 1, nums1[p.first] + nums2[p.second + 1]);
                heap.offer(newP);
            }
        }
        return result;
    }

    public static void main(String[] args){
        FindKPairswithSmallestSums fkpwss = new FindKPairswithSmallestSums();
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        fkpwss.kSmallestPairs(nums1, nums2, 9);
    }
}
