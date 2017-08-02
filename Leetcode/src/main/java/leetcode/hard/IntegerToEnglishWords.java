package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/5/29.
 */
public class IntegerToEnglishWords {
    String[] base = {"","Thousand","Million","Billion","Trillion"};
    Map<Integer, String> dict = new HashMap<>();
    {
        dict.put(1,"One");dict.put(2,"Two");dict.put(3,"Three");dict.put(4,"Four");dict.put(5,"Five");dict.put(6,"Six");
        dict.put(7,"Seven");dict.put(8,"Eight");dict.put(9,"Nine");dict.put(10,"Ten");dict.put(11,"Eleven");dict.put(12,"Twelve");
        dict.put(13,"Thirteen");dict.put(14,"Fourteen");dict.put(15,"Fifteen");dict.put(16,"Sixteen");dict.put(17,"Seventeen");
        dict.put(18,"Eighteen");dict.put(19,"Nineteen");dict.put(20,"Twenty");dict.put(30,"Thirty");dict.put(40,"Forty");
        dict.put(50,"Fifty");dict.put(60,"Sixty");dict.put(70,"Seventy");dict.put(80,"Eighty");dict.put(90,"Ninety");
    }
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int baseIndex = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int current = num%1000;
            String currentRead = readSection(current);
            if(currentRead.length() != 0)
                sb.insert(0, readSection(current) + " " + base[baseIndex]);
            num = num/1000;
            baseIndex++;
        }
        return sb.toString().trim();
    }

    public String readSection(int num){
        StringBuilder sb = new StringBuilder();
        int hundred = num/100;
        if(hundred > 0)
            sb.append(" " + dict.get(hundred)).append(" Hundred");
        num = num%100;
        if(num == 0) return sb.toString();
        if(dict.containsKey(num)){
            sb.append(" " + dict.get(num));
            return sb.toString();
        }
        else{
            int ten = num / 10;
            sb.append(" " + dict.get(ten*10));
            int digit = num % 10;
            sb.append(" " + dict.get(digit));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords itew = new IntegerToEnglishWords();
        int test = 1000000;
        System.out.println(itew.numberToWords(test));
    }

}
