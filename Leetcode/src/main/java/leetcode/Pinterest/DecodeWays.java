package leetcode.Pinterest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/6/20.
 */
public class DecodeWays {

    /**
     * Two versions,
     * 1. get count of number of decode ways,
     * 2. get all the result.
     * */
    //get Count
    public int decode1(int num){
        if(num == 0) return 0;
        String s = num+"";
        int[] count = new int[s.length()+1];
        count[0] = 1;
        count[1] = 1;
        /**
         * Basic ides is
         * check two chars, current and previous one.
         * one character always has one way of decode.
         * if between 10 and 26, inclusive. count[i] += count[i-2];
         * if current char is not 0, count[i] += count[i-1];
         * after accumulation, count[i] is still 0, means previous status cannot even decode, so we just return .
         * means we cannot decode. so return 0.
         * */
        for(int i = 2; i < count.length; i++){
            int number = 10*(s.charAt(i-2) - '0') + (s.charAt(i-1) - '0');
            if(num >= 10 && num <= 26)
                count[i] += count[i-2];
            if(s.charAt(i-1) != '0')
                count[i] += count[i-1];
            if(count[i] == 0)
                return 0;
        }
        return count[count.length-1];
    }

    public Set<String> decode2(String num){

        Map<Integer, Set<String>> track = new HashMap<>();
        for(int i = 0; i <= num.length(); i++)
            track.put(i, new HashSet<String>());
        track.get(1).add(((char)(num.charAt(0) - '0' - 1 + 'a')) + "");
        track.get(0).add("");

        for(int i = 2; i <= num.length(); i++){
            int number = 10*(num.charAt(i-2)-'0') + (num.charAt(i-1)-'0');
            if(number >= 10 && number <= 26){
                char current = (char)(number-1 + 'a');
                Set<String> existing = track.get(i-2);
                for(String s : existing)
                    track.get(i).add(s+current);
            }
            if(num.charAt(i-1) != '0'){
                char current = (char)(num.charAt(i-1)-'0'-1 + 'a');
                Set<String> existing = track.get(i-1);
                for(String s : existing)
                    track.get(i).add(s+current);
            }

            if(track.get(i).size() == 0)
                return new HashSet<String>();
        }
        return new HashSet<>(track.get(num.length()));
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        Set<String> result = dw.decode2("1234");
        System.out.println(result.size());
        for(String s : result)
            System.out.println(s);
    }


}
