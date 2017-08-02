package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cc on 2017/3/13.
 */
public class SubsetsII {

    /**
     * Basic idea is:
     * 1. sort array. so we can loop through from left to right. and compare with previous see if they equal to each other.
     * 2. if current not equals to previous.
     *    1.we set previousLength  = current result.size()
     *    2.We copy the whole result, add current to each element in the result. add them back to result.
     * 3. if current equals to previous.
     *    since only the last previousLength elements in the result are new, all previous results are result from adding current number.
     *    to avoid duplicates. we just take the last previous length, and add current number to them. add them back to result.
     *    we dont update previous length either.
     * */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        List<Integer> firstElement = new ArrayList<Integer>();
        firstElement.add(nums[0]);

        result.add(empty);
        result.add(firstElement);
        int previousLength = 1;

        for(int i = 1; i < nums.length; i ++){
            //if current equals previous.
            //we only take previous length long starting from the end.
            //append current number to the list. add the list to the result.
            if(nums[i] == nums[i-1]){
                for(int j = result.size() - 1, counter = 1;  counter <= previousLength; counter ++, j --){
                    List<Integer> temp = new ArrayList<Integer>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
            //if not equals.
            //update previous length = result.size();
            //copy the whole result. add num to each list of the copy.
            //add the copy to result.
            else{
                previousLength = result.size();
                for(int j = 0; j < previousLength; j++){
                    List<Integer> temp = new ArrayList<Integer>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2,2};
        SubsetsII ss = new SubsetsII();
        System.out.println(ss.subsetsWithDup(nums).size());
    }


}
