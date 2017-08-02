package leetcode.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/4.
 */
public class SortedArrayCountOccurrance {

    public List<int[]> getResult(int[] nums){
        List<int[]> result = new ArrayList<>();
        int start = 0;
        while(start < nums.length){
            int end = findLast(nums, start);
            result.add(new int[]{nums[start], end - start + 1});
            start = end + 1;
        }
        return result;
    }

    public int findLast(int[] nums, int start){
        int i = nums[start];
        int span = 1;
        //check 2^n position, if the same, keep spanning,
        //otherwise, binary search get start position.
        while(start + span < nums.length && nums[start+span] == i)
            span = span << 1;

        int end = start + span;
        if(end >= nums.length) end = nums.length - 1;

        //break the loop if there are two elements left.
        //since there are only == and >. if there are 2 left,
        //either way, will infinite loop.
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == i) start = mid;
            else end = mid;
        }
        if(nums[end] == i) return end;
        else return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3};
        SortedArrayCountOccurrance saco = new SortedArrayCountOccurrance();
        List<int[]> result = saco.getResult(arr);

        System.out.println(saco.findLast(arr, 0));

        for(int[] a : result) {
            System.out.println(a[0]);
            System.out.println(a[1]);
        }
    }

}
