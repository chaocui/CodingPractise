package leetcode.medium;

import java.util.LinkedHashMap;

/**
 * Created by cc on 2016/7/11.
 */
public class FractionToRecurringDecimal {

    /**
     * Basic idea,
     * (1) return 0;
     * (2) Determine negative or positive, make them both positive
     * (3) Do long division
     * -- module, remaining is zero or not.
     * if not zero, remaining * 10 as new numerator.
     * Keep track of remaining, if a remaining show up again.
     * from tha remaining position to end will be the repeat part.
     */

    public String fractionToDecimal(int left, int right) {

        long numerator = Long.valueOf(left);
        long denominator = Long.valueOf(right);

        if(numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if(numerator < 0 && denominator < 0){
            ;
        }
        else if(numerator < 0 || denominator < 0) {
            result.append("-");
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        LinkedHashMap<Long, Long> remainningTrack = new LinkedHashMap<>();
        long remaining = 0;
        long position = 0;
        boolean first = true;

        while(true){
            long module = numerator/denominator;
            result.append(module);
            remaining = numerator % denominator;
            if(first && remaining != 0){
                result.append(".");
                first = false;
            }
            if(remaining == 0)
                return result.toString();

            if(remainningTrack.containsKey(remaining)){
                break;
            }

            remainningTrack.put(remaining, position);
            position++;
            numerator = 10*remaining;
        }
        Long startIndex = remainningTrack.get(remaining) + result.indexOf(".") + 1;
        result.insert(startIndex.intValue(), "(");
        result.append(")");
        return result.toString();
    }

    public static void main(String[] args){

        FractionToRecurringDecimal ftd = new FractionToRecurringDecimal();
        System.out.println(ftd.fractionToDecimal(-1,-2147483648));

    }

}
