package leetcode.Lyft;

/**
 * Created by cc on 2017/6/26.
 */
public class ReverseInteger {

    public int solution(int num){
        if(num < 10) return num;
        boolean neg = num < 0;
        num = Math.abs(num);
        int result = 0;
        while(num != 0){
            int remain = num % 10;
            num = num / 10;
            result = result*10 + remain;
        }
        return neg ? -result : result;
    }
}
