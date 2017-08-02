package leetcode.easy;

/**
 * Created by cc on 2017/4/20.
 */
public class AddBinary {

    /**
     * Easy version of add two list from right to left.
     * List add, use stack and add result after head.
     *
     * This we just loop from right of the string.
     * insert to the beginning of string builder.
     * */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int ad = 0, bd = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >=0 || j >= 0; i--, j--){
            ad = 0;bd = 0;
            if(i >= 0)
                ad = a.charAt(i) - '0';
            if(j >= 0)
                bd = b.charAt(j) - '0';
            int sum = ad + bd + carry;
            carry = sum/2;
            int temp = sum%2;
            result.insert(0,temp);
        }
        if(carry != 0)
            result.insert(0,carry);
        return result.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11","1"));
    }

}
