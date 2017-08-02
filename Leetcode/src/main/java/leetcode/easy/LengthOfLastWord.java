package leetcode.easy;

/**
 * Created by cc on 2017/4/21.
 */
public class LengthOfLastWord {
    //Loop from last to beginning.
    //Loop until first non space. char
    //start count until first space.
    public int lengthOfLastWord(String s) {
        //Step 1. take out trailing spaces.
        int i = s.length() - 1;
        int result = 0;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        while(i >= 0 && s.charAt(i) != ' '){
            result ++;
            i--;
        }
        return result;
    }

}
