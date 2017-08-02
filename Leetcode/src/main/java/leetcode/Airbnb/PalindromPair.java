package leetcode.Airbnb;

import java.util.*;

/**
 * Created by cc on 2017/6/30.
 */
public class PalindromPair {

    //Four situations.
    //1. "" + palindrome itself
    //2. word and it reverse in the dict (index not the same, we include palindrome itself before)
    //3. first half is palindrome, second half reverse in dict.
    //4. second hasl is palindrome, first half reverse in dict.
    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> dict = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            dict.put(words[i],i);
        List<List<Integer>> result = new ArrayList<>();

        //case 1
        if(dict.containsKey("")){
            int index = dict.get("");
            for(int i = 0; i < words.length; i++){
                //skip the empty string. empty is palindrome for sure.
                if(i == index)
                    continue;

                if(isP(words[i])){
                    result.add(Arrays.asList(index, i));
                    result.add(Arrays.asList(i, index));
                }
            }
        }

        //case 2, word and its reverse are in dict, skip the word which is palindrome, counted before.
        for(int i = 0; i < words.length; i++){
            String reverse = reverseS(words[i]);
            if(dict.containsKey(reverse)) {
                int rIndex = dict.get(reverse);
                if (i == rIndex) continue;
                //only need to add i and rIndex.
                //because when reach the reverse, rIndex and i will be added. so no duplicates
                result.add(Arrays.asList(i, rIndex));
            }
        }

        //case 3, and case 4.
        for(int i = 0; i < words.length; i++){
            for(int j = 1; j < words[i].length(); j++){
                //case 3
                String leftSub = words[i].substring(0,j);
                String rightSub = words[i].substring(j);
                if(isP(leftSub)){
                    String reverse = reverseS(rightSub);
                    if(dict.containsKey(reverse)){
                        int index = dict.get(reverse);
                        result.add(Arrays.asList(index, i));
                    }
                }
                if(isP(rightSub)){
                    String reverse = reverseS(leftSub);
                    if(dict.containsKey(reverse)){
                        int index = dict.get(reverse);
                        result.add(Arrays.asList(i, index));
                    }
                }
            }
        }
        return result;
    }

    public boolean isP(String s){
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }

    public String reverseS(String s){
        return new StringBuilder(s).reverse().toString();
    }

}
