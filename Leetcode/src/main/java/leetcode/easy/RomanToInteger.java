package leetcode.easy;

import java.util.HashMap;

/**
 * Created by cc on 2016/8/6.
 */
public class RomanToInteger {

    public int romanToInt(String s) {

        HashMap<String, Integer> dic = new HashMap();
        dic.put("M", 1000);
        dic.put("CM", 900);
        dic.put("D", 500);
        dic.put("CD", 400);
        dic.put("C", 100);
        dic.put("XC", 90);
        dic.put("L", 50);
        dic.put("XL", 40);
        dic.put("X", 10);
        dic.put("IX", 9);
        dic.put("IV", 4);
        dic.put("V", 5);
        dic.put("I", 1);

        int result = 0;
        for(int i = 0; i < s.length(); i++){

            if(i+1 < s.length()){
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i)).append(s.charAt(i+1));
                if(dic.containsKey(sb.toString())){
                    result += dic.get(sb.toString());
                    i++;
                }
                else{
                    result += dic.get(s.charAt(i)+"");
                }
            }
            else{
                result += dic.get(s.charAt(i)+"" );
            }
        }
        return result;
    }

    /*
    * 还没有上面的方法快！
    * */
    public int romanToInt2(String s){
        HashMap<String, Integer> dic = new HashMap();
        dic.put("M", 1000);
        dic.put("D", 500);
        dic.put("C", 100);
        dic.put("L", 50);
        dic.put("X", 10);
        dic.put("V", 5);
        dic.put("I", 1);

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            int current = dic.get(s.charAt(i)+"");
            if(i > 0 && current > dic.get(s.charAt(i-1)+"")){
                int pre = dic.get(s.charAt(i-1)+"");
                //If the current one is greater than the previous one.
                //current and previous construct combination, and result is current - pre.
                //So we abstract the pre and plus current - pre
                result = result - pre + (current - pre);
            }
            else{
                result = result + current;
            }
        }
        return result;
    }
}
