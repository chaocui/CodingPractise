package leetcode.hard;

import java.util.*;

/**
 * Created by cc on 2016/11/8.
 */
public class RemoveDuplicateLetters {
    /**
     * basic idea:
     * Use a stack to keep track of result
     * use a set to keep track of visited character
     * use a hash map to keep track of count of each character.
     *
     * Loop through characters
     * minus the count by 1
     * if not visited, check stack top with current char,
     * if stack not empty && stack top > current && in hash map, stack top count greater than 0.
     * which means that this top character still has chance to show up and fit the lexicographical after current character
     * pop out and remove this top character from visited, until break the loop
     *
     * If visited, then continue, means the character is already in position(which is guaranteed in not visited step).
     *
     * http://bookshadow.com/weblog/2015/12/09/leetcode-remove-duplicate-letters/
     * * */
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        Set<Character> visited = new HashSet<Character>();
        //Keep track of each character count
        for(char c : s.toCharArray()){
            if(dict.containsKey(c)){
                dict.put(c,dict.get(c)+1);
            }
            else{
                dict.put(c,1);
            }
        }

        Stack<Character> stack = new Stack<Character>();
        //Loop through all characters
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //minus 1 in hash map
            dict.put(c,dict.get(c)-1);
            if(visited.contains(c)){
                continue;
            }

            //if stack not empty && stack top > current && in hash map, stack top count greater than 0.
            //which means that this top character still has chance to show up and fit the lexicographical after current character
            //pop out and remove this top character from visited, until break the loop
            while(!stack.isEmpty() && stack.peek() > c && dict.get(stack.peek()) > 0){
                visited.remove(stack.pop());
            }
            //Add current to visited, and stack.
            visited.add(c);
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
