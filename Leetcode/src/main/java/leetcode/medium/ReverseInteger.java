package leetcode.medium;

/**
 * Created by cc on 2017/3/10.
 */
public class ReverseInteger {

    //Interesting point!!!!
    //We store the temp new Result.
    //Then we use the temp result to get previous result.
    //(tempResult - lastDigit)/10. if the value is not previous result.
    //meaning it overflows, we return 0 directly.
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int lastDigit = x%10;
            int tempResult = result*10+lastDigit;
            if((tempResult - lastDigit)/10 != result)
                return 0;
            result = tempResult;
            x = x/10;
        }
        return result;
    }

}
