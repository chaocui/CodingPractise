package leetcode.Uber;

/**
 * Created by cc on 2017/6/12.
 */
public class StringEncode {

    /**
     * aaabbcacdddffe
     *
     * encode to 3a2b1c1a1c3d2f1e
     * */
    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1))
                count++;
            else{
                sb.append(count).append(s.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count).append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "aaabbcacdddff";
        StringEncode se = new StringEncode();
        System.out.println(se.solution(test));
    }


}
