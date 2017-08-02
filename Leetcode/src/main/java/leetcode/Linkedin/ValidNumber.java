package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/12.
 */
public class ValidNumber {

    public boolean isNumber(String input) {
        String s = input.trim();
        boolean seenNumber = false;
        boolean seenE = false;
        boolean numberAfterE = true;
        boolean pointSeen = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                seenNumber = true;
                numberAfterE = true;
            }
            else if(s.charAt(i) == '.'){
                if(seenE || pointSeen) return false;
                pointSeen = true;
            }
            //number after e always be true until we see e, then we set it to false until we see more number after e.
            else if(s.charAt(i) == 'e'){
                if(seenE || !seenNumber) return false;
                seenE = true;
                numberAfterE = false;
            }
            else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i-1) != 'e') return false;
            }
            else
                return false;
        }
        return seenNumber && numberAfterE;
    }

    public static void main(String[] args) {
        String test = "000";
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber(test));
    }

}
