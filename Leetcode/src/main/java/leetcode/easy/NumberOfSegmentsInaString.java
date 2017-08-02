package leetcode.easy;

/**
 * Created by cc on 2017/4/23.
 */
public class NumberOfSegmentsInaString {

    /**
     * Basic idea is
     * keep track of previous is space or not.
     *
     * if current is not space and previous is space. this is start of a segment, result++;
     * keep updating previous space boolean based on current character.
     * */
    public int countSegments(String s) {
        int result = 0;
        boolean preSpace = true;
        for(char c : s.toCharArray()){
            if(c != ' ' && preSpace){
                result ++;
                preSpace = false;
            }
            if(c == ' ')
                preSpace = true;
            else
                preSpace = false;
        }
        return result;
    }

}
