package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2017/3/26.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> firstElement  = new ArrayList<Integer>();
        firstElement.add(nums[0]);
        result.add(firstElement);
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            for(int j = 0; j < result.size(); j++){
                List<Integer> eachResult = result.get(j);
                //insert the new number to each position of each Result become a new result.
                //add it to temp result.
                for(int m = 0; m <= eachResult.size(); m++){
                    //copy current result, add to different position.
                    List<Integer> tempEachResult = new ArrayList<Integer>(eachResult);
                    tempEachResult.add(m,nums[i]);
                    tempResult.add(new ArrayList<>(tempEachResult));
                }
            }
            //Once processed all current results.
            //just clear result, add everything from tempResult to result.
            result.clear();
            result.addAll(tempResult);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
        Permutations p = new Permutations();
        List<List<Integer>> result = p.permute(test);
        for(List<Integer> each : result){
            System.out.println(Arrays.toString(each.toArray()));
        }
    }
}
