package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2016/11/1.
 */
public class IntegerToEnglishWord {

    private Map<Integer, String> digitalHelper = new HashMap<Integer, String>();

    public IntegerToEnglishWord(){
        digitalHelper.put(1,"One");
        digitalHelper.put(2,"Two");
        digitalHelper.put(3,"Three");
        digitalHelper.put(4,"Four");
        digitalHelper.put(5,"Five");
        digitalHelper.put(6,"Six");
        digitalHelper.put(7,"Seven");
        digitalHelper.put(8,"Eight");
        digitalHelper.put(9,"Nine");
        digitalHelper.put(10,"Ten");
        digitalHelper.put(11,"Eleven");
        digitalHelper.put(12,"Twelve");
        digitalHelper.put(13,"Thirteen");
        digitalHelper.put(14,"Fourteen");
        digitalHelper.put(15,"Fifteen");
        digitalHelper.put(16,"Sixteen");
        digitalHelper.put(17,"Seventeen");
        digitalHelper.put(18,"Eighteen");
        digitalHelper.put(19,"Nineteen");
        digitalHelper.put(20,"Twenty");
        digitalHelper.put(30,"Thirty");
        digitalHelper.put(40,"Forty");
        digitalHelper.put(50,"Fifty");
        digitalHelper.put(60,"Sixty");
        digitalHelper.put(70,"Seventy");
        digitalHelper.put(80,"Eighty");
        digitalHelper.put(90,"Ninety");
    }



    public String numberToWords(int num) {
        String sections[] = {"", "Thousand", "Million", "Billion"};
        String result = "";
        int section = 0;
        while(num > 0){
            int remaining = num % 1000;
            String currentSay = sayWord(remaining);
            result = currentSay + " " + sections[section] + " " + result;
            num = num / 1000;
            section++;
        }
        return result.trim();
    }

    public String sayWord(int num){
        StringBuilder result = new StringBuilder();
        result.append(digitalHelper.get((num/100))).append(" Hundred ");
        num = num % 100;
        if(digitalHelper.containsKey(num)){
            result.append(digitalHelper.get(num));
        }
        else{
            result.append(digitalHelper.get((num/10)*10));
            num = num%10;
            result.append(" " + digitalHelper.get(num));
        }
        return result.toString();
    }

    public static void main(String[] args){
        IntegerToEnglishWord itew = new IntegerToEnglishWord();
        System.out.println(itew.numberToWords(122324));
    }
}
