package leetcode.Lyft;

/**
 * Created by cc on 2017/6/26.
 */
public class StringShifts {

    public String solution(String s, int shift){
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray())
            result.append((char)(((c - 'a') + shift)%26 + 'a'));
        return result.toString();
    }

    public static void main(String[] args) {
        StringShifts ss = new StringShifts();
        System.out.println(ss.solution("xyz",2));
    }

}
