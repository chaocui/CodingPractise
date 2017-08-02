package leetcode.Airbnb;

/**
 * Created by cc on 2017/6/24.
 */
public class AddString {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        /**
         * As long as there is one has more digit to process,
         * we just keep processing until both number are done.
         * */
        for(; i>=0 || j>=0 ; i--, j--){
            int c1 = 0, c2 = 0;
            if(i >= 0)
                c1 = num1.charAt(i) - '0';
            if(j >= 0)
                c2 = num2.charAt(j) - '0';
            int d = (c1 + c2 + carry)%10;
            carry = (c1+c2+carry)/10;
            sb.insert(0, d);
        }
        if(carry != 0)
            sb.insert(0,carry);
        return sb.toString();
    }

}
