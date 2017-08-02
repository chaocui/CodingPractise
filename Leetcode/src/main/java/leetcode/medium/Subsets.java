package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/3/20.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int length = result.size();
            for(int i = 0; i < length; i++){
                List<Integer> each = result.get(i);
                List<Integer> newEach = new ArrayList<Integer>(each);
                newEach.add(n);
                result.add(newEach);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
        Subsets s = new Subsets();
        s.subsets(test);
    }

}
