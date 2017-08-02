package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/5/22.
 */
public class PalindromePermutationII {

    /**
     * Basic idea,
     * count the chars in string.
     * if number of odd number of chars are not even, return false.
     * then take half of the chars.
     * generate the permutations.
     * mid char is empty or the odd char.
     * permutation + mid + permutation.reverse is on palindrome result.
     * */
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        String mid = "";
        List<String> result = new ArrayList<>();
        int noOfOdd = 0;
        for(char c : s.toCharArray()){
            dict.put(c, dict.getOrDefault(c,0)+1);
            //logic here is ,every time we add to the map,
            //if count is odd, add 1, if count is even, minus 1.
            //so if odd is eventually the no of odd chars
            noOfOdd += dict.get(c)%2 == 0 ? -1 : 1;
        }
        if(noOfOdd > 1) return result;
        List<Character> chars = new ArrayList<>();
        for(Map.Entry<Character, Integer> each : dict.entrySet()){
            int v = each.getValue();
            char c = each.getKey();
            if(v%2 != 0) mid = c+"";
            //odd might be three chars. so aaa, mid is a, and add 1 a to charlist.
            //so any way, we need to add char to chars.
            //depending on its even or odd and the numbers,
            for(int  i = 0; i < v/2; i++) chars.add(c);
        }
        getPerm(chars, mid, new boolean[chars.size()],new StringBuilder(),result);
        return result;
    }

    public void getPerm(List<Character> chars, String mid, boolean[] used, StringBuilder sb, List<String> result){
        if(sb.length() == chars.size()){
            result.add(sb.toString() + mid + sb.reverse());
            sb.reverse();
            return;
        }

        for(int i = 0; i < chars.size(); i++){
            //avoid duplicates.
            //if i > 0 means, loop went to next iteration.
            //if current char is equal with previous and previous is not used, means that we starting over,
            //previous char has been used to form permutation already, current char as first will form dups.
            if(i > 0 && chars.get(i) == chars.get(i-1) && !used[i-1]) continue;
            if(!used[i]){
                used[i] = true; sb.append(chars.get(i));
                getPerm(chars, mid, used, sb, result);
                used[i] = false; sb.deleteCharAt(sb.length()- 1);
            }
        }
    }
}
