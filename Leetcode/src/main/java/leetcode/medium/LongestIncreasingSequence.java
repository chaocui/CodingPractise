package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2016/11/20.
 */
public class LongestIncreasingSequence {

    /*
    * DP
    * dp[i] means till num[i], longest increase sequence.
    * */
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }

    /*
    *  binary search,
    *  for each number
    *  if it is smaller than first, replace first, if greater then last, replace last,
    *  if it is in the middle, binary search, replace the first one which is greater or equal to it.
    * */
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        LinkedList<Integer> result = new LinkedList<Integer>();
        result.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > result.getLast()){
                result.add(nums[i]);
            }
            else if(nums[i] < result.getFirst()){
                result.removeFirst();
                result.addFirst(nums[i]);
            }
            else{
                int start = 0, end = result.size() - 1;
                while(start < end){
                    int mid = (start + end)/2;
                    if(nums[i] <= result.get(mid)){
                        end = mid;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                result.remove(end);
                result.add(end, nums[i]);
            }
        }
        return result.size();
    }

    public static void main(String[] args){
        LongestIncreasingSequence lis = new LongestIncreasingSequence();
        int test[] = {4,4,4,4};
        System.out.println(lis.lengthOfLIS1(test));
    }

}
