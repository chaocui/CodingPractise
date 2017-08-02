package leetcode.Facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cc on 2017/5/31.
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        int removeLeft = 0, removeRight = 0;
        for(char c : s.toCharArray()){
            if(c == '(')
                removeLeft ++;
            //since we have other characters, we need to specify c == ')' or '('
            else if(c == ')'){
                if(removeLeft > 0)
                    removeLeft--;
                else
                    removeRight++;
            }
        }

        //use set to remove duplicate.
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        getResult(s, 0, 0,removeLeft, removeRight, result, sb);
        return new ArrayList<>(result);
    }

    public void getResult(String s, int start, int open, int left, int right, Set<String> result, StringBuilder sb){
        //at any point , open < 0, means that there is extra ) in the string, which is invalid. we return.
        if(left < 0 || right < 0 || open < 0) return;
        if(s.length() == start){
            if(left == 0 && right == 0) result.add(sb.toString());
            return;
        }

        int l = sb.length();
        //Need a variable open to track sinario like ()()), if at any point, string starting as ), it is invalid
        //then just return .
        if(s.charAt(start) == '('){
            getResult(s, start+1, open, left-1, right, result, sb);//not use
            getResult(s, start+1, open+1, left, right, result, sb.append('('));//use
        }
        else if(s.charAt(start) == ')'){
            getResult(s, start+1, open, left, right-1, result, sb);//not use
            getResult(s, start+1, open-1, left, right, result, sb.append(')')); //use
        }
        else{
            getResult(s, start+1, open, left, right, result, sb.append(s.charAt(start)));//use any way
        }
        //remove what has been appended.
        sb.setLength(l);
    }
}
