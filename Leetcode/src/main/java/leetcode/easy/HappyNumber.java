package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2016/4/9.
 */
public class HappyNumber {

    public boolean isHappy(int num){

        Set<Integer> visited = new HashSet();
        int eachValue = num;

        while(true){

            if(eachValue == 1)
                return true;

            if(eachValue == 0)
                return false;

            visited.add(eachValue);
            int midValue = getSum(eachValue);
            if(visited.contains(midValue))
                return false;
            else {
                eachValue = midValue;
            }
        }
    }

    private int getSum(int num){

        String s = Integer.toString(num);
        int result = 0;
        for(int i = 0 ; i < s.length(); i++){
            int c = s.charAt(i) - '0';
            result += c*c;
        }
        return result;
    }

}
