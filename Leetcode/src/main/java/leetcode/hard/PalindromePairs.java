package leetcode.hard;

import java.util.*;

/**
 * Created by cc on 2016/11/5.
 */
public class PalindromePairs {

    /**
     * Four case
     * 1. "" empty string, any string that is palindrome, s1s2 s2s1 are part of result
     * 2. s1 and s1 reverse(s2), s1s2, s2s1 are part of result
     * 3. s1(0,i) is palindrome, s1(i, end) reverse in map, s2s1 is part of result
     * 4, s1(i,end) is palindrome, s1(0,i) reverse in map, s1s2 is part of result
     * */

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> dict = new HashMap<String, Integer>();

        for(int i = 0; i < words.length; i++){
            dict.put(words[i], i);
        }

        if(dict.containsKey("")){
            int emptyIndex = dict.get("");
            for(int i = 0; i < words.length; i++){
                if(emptyIndex == i){
                    continue;
                }
                String w = words[i];
                if(isP(w)){
                    result.add(Arrays.asList(i,emptyIndex));
                    result.add(Arrays.asList(emptyIndex, i));
                }
            }
        }

        //Case 2: s and s reverse are the same
        //String itself is palindrome is counted before.
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            String wr = reverseStr(w);
            if(dict.containsKey(wr)){
                int indexR = dict.get(wr);
                if(indexR == i){
                    continue;
                }
                result.add(Arrays.asList(indexR,i));
            }
        }

        //case 3: s[0,i] is palindrome, s[i,end] reverse in dict. s2s1
        //case 4: s[i, end] is palindrome, s[0,i] reverse in dict, s1s2
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            for(int j = 1; j < w.length(); j++){
                //case 3
                String subP = w.substring(0,j);
                if(isP(subP)){
                    String reverse = reverseStr(w.substring(j));
                    if(dict.containsKey(reverse)){
                        int index = dict.get(reverse);
                        result.add(Arrays.asList(index, i));
                    }
                }

                String subA = w.substring(j);
                if(isP(subA)){
                    String reverse = reverseStr(w.substring(0,j));
                    if(dict.containsKey(reverse)){
                        int index = dict.get(reverse);
                        result.add(Arrays.asList(i,index));
                    }
                }
            }
        }
        return result;
    }

    public String reverseStr(String str){
        StringBuilder sb= new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isP(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
