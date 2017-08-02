package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2016/4/6.
 */
public class ContainsDuplicate {

    public static boolean containsDuplicat(int[] nums){

        Map<Integer, Integer> dic = new HashMap();

        for(int i = 0; i < nums.length; i++){
            if(dic.containsKey(nums[i]))
                return true;
            else
                dic.put(nums[i], 1);
        }

        return false;
    }

    public static void main(String[] args){

        int i = 0;
        int[] nums = new int[30000];
        while(i < 30000){
            nums[i] = i;
            i++;
        }

        System.out.println(containsDuplicat(nums));

    }


}
