package leetcode.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/6/5.
 */
public class AddBridgeToSameChar {

    /**
     * Description.
     * ABCDAABDADCCAACA
     * same characters need n distance away, if not fill with _;
     * */
    public String solution(String s, int n){
        /**
         * Basic idea is use hashmap to keep track last same character show up location,
         * if current location and last location less than n, fill up with _, otherwise
         * print and updated hashmap.
         * */
        Map<Character, Integer> tracker = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //detail part is use extra variable to keep track the position.
        //append char this variable need to increase.
        //append _ this variable also need to increase.
        //Since _ also occupy space after modify the original string.
        int currentPosition = 0;
        for(char c : s.toCharArray()){
            if(!tracker.containsKey(c) || currentPosition - tracker.get(c) - 1 >= n) {
                sb.append(c);
                tracker.put(c, currentPosition);
                currentPosition++;
            }
            else{
                int l = n - (currentPosition - tracker.get(c) - 1);
                for(int j = 0; j < l; j++) {
                    sb.append("_");
                    currentPosition++;
                }
                sb.append(c);
                tracker.put(c,currentPosition);
                currentPosition++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBridgeToSameChar abts = new AddBridgeToSameChar();
        System.out.println(abts.solution("ABCDAABDADCCAACA",3));
    }
}
