package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2016/11/1.
 *
 * Basic idea,
 * Two hash map,
 * one contains needs to found
 * one contains found for each loop start from each character in the string s, until s.length - totalLength of dict.
 * (Since if length is not enough, does not need to check)
 *
 * loop through s, start from each character.
 * inner loop, loop through dict.length times.
 * each time step forward dict[0] length to get substring.
 * Check substring is in toFind, if not break;
 * if in check found, if in +1, if not put 1.
 * then check how many has been found, if greater than toFind, break;
 * After inner loop, if index == dict.length. means loops done, so this position is one of the result.
 * otherwise, loop break, either not in toFind, or found more than expected.
 */
public class SubstringWithContacenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> toFind = new HashMap<String, Integer>();
        Map<String, Integer> found = new HashMap<String, Integer>();
        int eachWordLength = words[0].length();
        int howManyWords = words.length;
        int totalLength = 0;

        for(String word : words){
            totalLength += word.length();
            if(toFind.containsKey(word)){
                toFind.put(word, toFind.get(word)+1);
            }
            else{
                toFind.put(word, 1);
            }
        }
        for(int i = 0; i <= s.length() - totalLength; i++){
            found.clear();
            int j = 0;
            for(j = 0; j < howManyWords; j++){
                int start = i + j * eachWordLength;
                String word = s.substring(start, start + eachWordLength);

                if(toFind.containsKey(word)){
                    if(found.containsKey(word)){
                        found.put(word, found.get(word)+1);
                    }
                    else{
                        found.put(word, 1);
                    }
                    if(found.get(word) > toFind.get(word)){
                        break;
                    }
                }
                else{
                    break;
                }
            }
            if(j == howManyWords){
                result.add(i);
            }
        }
        return result;
    }
}
