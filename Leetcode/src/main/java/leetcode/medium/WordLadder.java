package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2016/7/17.
 */
public class WordLadder {

    private class StepToString{
        String s;
        int count;
        public StepToString(String s, int count){
            this.s = s;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<StepToString> queue = new LinkedList<StepToString>();
        Set<String> visited = new HashSet<String>();

        queue.offer(new StepToString(beginWord, 1));
        while(!queue.isEmpty()){

            StepToString current = queue.poll();
            String s  = current.s;

            //Change one character in s
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < 26; j++){
                    String temp = replace(current.s, i, (char)('a'+j));
                    if(temp.equals(endWord)){
                        return current.count+1;
                    }
                    if((!visited.contains(temp)) && wordList.contains(temp) && !temp.equals(current.s)){
                        visited.add(temp);
                        queue.offer(new StepToString(temp, current.count+1));
                    }
                }
            }
        }
        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    public static void main(String[] args){
        WordLadder wl = new WordLadder();
        Set<String> s = new HashSet();
        s.add("a");
        s.add("b");
        s.add("c");
        wl.ladderLength("a", "0",s );
    }


}
