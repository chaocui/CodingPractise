package leetcode.easy;

/**
 * Created by cc on 2016/4/10.
 */
public class PowerOfThree {

    public boolean powerOfThree(int num){

        if(num <= 0)
            return false;

        while(num > 1){

            if(num % 3 != 0)
                return false;
            else
                num = num / 3;
        }
        return true;
    }

}
