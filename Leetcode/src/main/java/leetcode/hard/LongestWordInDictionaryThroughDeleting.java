package leetcode.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cc on 2017/3/25.
 */
public class LongestWordInDictionaryThroughDeleting {

    /**
     * Basic idea,
     * We can sort dictionary D to make sure they are in order.
     * Sort by length first, if length equals, then sort by alphabetic order.
     * We can loop through the dictionary D.
     * For each d, we can check if this is a subsequence of s.
     * If current d is, then we just return .
     * */
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() == o1.length() ? o1.compareTo(o2) : o2.length() - o1.length();
            }
        });
        for(String eachString : d){
            //Mark d index;
            int dIndex = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == eachString.charAt(dIndex))
                    dIndex++;
                //If dIndex reach the end, means that all chars in eachString match a subsequece of s.
                //So eachString must be the result.
                if(dIndex == eachString.length()) return eachString;
            }
        }
        return "";
    }
}
