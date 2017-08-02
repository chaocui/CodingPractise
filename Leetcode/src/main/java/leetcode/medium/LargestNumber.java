package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by cc on 2016/7/21.
 */
public class LargestNumber {

    public class StringComparator implements Comparator<String>{
        @Override
        //From big to small, so reverse order. return negative result
        public int compare(String o1, String o2) {
            return -(o1+o2).compareTo(o2+o1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strings[i] = nums[i] + "";
        }
        Arrays.sort(strings, new StringComparator());
        StringBuilder result = new StringBuilder();
        for(String s: strings){
            result.append(s);
        }
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) != '0'){
                break;
            }
            else if(i == result.length() - 1 && result.charAt(i) == '0'){
                return "0";
            }
        }

        return result.toString();
    }

}
