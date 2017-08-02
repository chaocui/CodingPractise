package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/4/2.
 */
public class SortCharactersByFrequency {

    //TreeMap.
    //Key is the count, value is the list of characters.
    //1. Count the frequency of each character.
    //2. loop through the frequency, based on the frequency, put the characters in the value

    //Should know the usage of TreeMap very very useful and powerful.
    //
    public String frequencySort(String s) {
        TreeMap<Integer, List<Character>> tree = new TreeMap<>();
        int[] count = new int[256];
        for(char c : s.toCharArray()) count[c]++;
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0){
                if(!tree.containsKey(count[i]))
                    tree.put(count[i],new ArrayList<Character>());
                tree.get(count[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!tree.isEmpty()){
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            //each char in this entry, appears entry.getKey() times.
            for(char c : entry.getValue()){
                char[] temp = new char[entry.getKey()];
                Arrays.fill(temp, c);
                sb.append(new String(temp));
            }
        }
        return sb.toString();
    }

}
