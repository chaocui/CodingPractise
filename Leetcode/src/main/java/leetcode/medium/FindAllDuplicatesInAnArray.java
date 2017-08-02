package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/1/31.
 */
public class FindAllDuplicatesInAnArray {

    //Basic idea is
    //Since the numbers in array are between 1 and n.
    //So use value as index and keep swapping.
    //For each position.
    //1, if index and value match, continue.
    //2, if the value-index position is the same value, add to result, continue;

    //Loop through again, if index value not match, thats part of result.

    //Tricky solution
    //// when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    //Basically use the property that all value are indexes.
    //So treat nums as hash map. loop through values, use each value as index, and mark the valued-index position as visited.
    //If visited twice, means that the index showed up twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result  = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }
}
