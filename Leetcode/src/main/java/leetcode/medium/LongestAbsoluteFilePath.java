package leetcode.medium;

import java.util.Stack;

/**
 * Created by cc on 2017/3/18.
 */
public class LongestAbsoluteFilePath {

    //basic idea,
    //use stack. to track each part.
    //stack size should be the number of levels currently we are at.

    //So for each component in the array.
    //we find the level of current component, from the stack we get the parent path length. by keep pop out until
    //stack size is one less than level. means level + 1 > stack.size() we break;
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int maxLength = 0;
        for(String s : input.split("\n")){
            int level = s.lastIndexOf("\t") + 1;
            //find the parent.
            //this is because the way the given string is.
            //the given string will go until the end of each path, then start next path.
            while(level + 1 < stack.size()) stack.pop();
            //add / to the end, so add 1.
            int currentLen = stack.peek() + s.length() - level + 1;
            stack.push(currentLen);
            //since added / at the end, if this is a file name, we need to substract 1 to remove the /
            if(s.indexOf(".") > 0) maxLength = Math.max(maxLength,currentLen-1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "dir\n\tasdf";
        System.out.println(s);
    }

}
