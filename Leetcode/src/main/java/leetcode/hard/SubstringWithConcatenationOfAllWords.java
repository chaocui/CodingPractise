package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/12.
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * Very easy solution and idea.
     *
     * Two hash map one used to track what we need to find.
     * The other is used to track what we already found.
     * Starting from each loop, we clear the found map.
     *
     * loop through the string starting from each index.
     * we only loop through the number of words in the words array.
     * we skip only the length of the array.
     * any substring is not in words, we break the loop.
     * if in words, we put in found. then check found and toFind if found more than toFind. we break.
     *
     * Then we check if the loop ends naturelly. if yes, i is one of the result.
     *
     * For the first loop, i <= s.length() - totalLength.
     * Has to be <=. since we cannot miss the last possible substring. which is starting at s.length() - totalLength to the end.
     *
     * */
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> toFind = new HashMap<>();
        Map<String, Integer> found = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int noOfWords = words.length;
        int wordLen = words[0].length();
        int totalLen = noOfWords*wordLen;
        for(String word : words) toFind.put(word, toFind.getOrDefault(word,0)+1);
        for(int i = 0; i <= s.length() - totalLen; i++){
            //before each loop, we clear found.
            found.clear();
            int j = 0;
            for(j = 0; j < noOfWords; j++){
                int start = i + wordLen*j;
                String word = s.substring(start, start + wordLen);
                if(toFind.containsKey(word)){
                    found.put(word, found.getOrDefault(word, 0) + 1);
                    if(toFind.get(word) < found.get(word)) {
                        break;
                    }
                }
                else{
                    break;
                }
            }
            //if all passed, i is one of the result
            if(j == noOfWords) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] test = {"word","good","best","good"};
        SubstringWithConcatenationOfAllWords swcoaw = new SubstringWithConcatenationOfAllWords();
        swcoaw.findSubstring(s, test);
    }


}
