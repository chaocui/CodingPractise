package leetcode.medium;

/**
 * Created by cc on 2017/6/11.
 */
public class StringToInteger {

    /**
     * Are you assuming there is no character in input besides + and -????
     * Looks like all the answers did not consider this.
     *
     * if starting with other characters, just return 0
     *
     * Now the most difficult part is how to handle overflow
     *
     * Smart solution:
     * Check previous result, see if its greater than Integer.Max/10.
     * or equal to Integer.max/10 and current digit is greater than 7
     *
     * Dont forget to increase i.. otherwise will end up with Integer.MAX all the time.
     * */
    public int myAtoi(String str) {
        int result = 0, sign = 1, i = 0;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        if(i < str.length()){
            if(str.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            else if(str.charAt(i) == '+')
                i++;
        }
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && str.charAt(i) > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        StringToInteger sti  = new StringToInteger();
        System.out.println(sti.myAtoi("1"));
    }

}
