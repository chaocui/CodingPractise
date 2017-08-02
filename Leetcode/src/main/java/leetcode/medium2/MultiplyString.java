package leetcode.medium2;

/**
 * Created by cc on 2017/4/29.
 */
public class MultiplyString {

    /**
     * Basic idea:
     * from right to left.
     * Multiply digit one by one.
     * Two number multiply, the maximum is l1+l2
     * So result array is new int[l1+l2]
     * Fill up array from right to left.
     *
     * */
    public String multiply(String num1, String num2){
        int l1 = num1.length(), l2 = num2.length();
        if(l1 == 0 || l2 == 0) return "0";
        int[] result = new int[l1+l2];
        for(int i = l1 - 1; i >= 0; i--){
            for(int j = l2 - 1; j >= 0; j--){
                //Can just give a simple example, then can figure out.
                //325*32, 0,1,2 and 0,1. So right most is 2+1 = 3. The result can be 5 digits.
                //So result right most is 3+1 which is i+j+1;
                int cP = i+j+1, pP = i + j;
                int prod = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = prod+result[cP];
                result[cP] = sum%10;
                result[pP] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        //if there is no number in sb, and current result is 0.
        //meaning these are the 0s at the beginning of result. ignore them.
        for(int n : result){
            if(sb.length() == 0 && n == 0) continue;
            sb.append(n);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
