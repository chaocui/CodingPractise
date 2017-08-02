package leetcode.easy;

/**
 * Created by cc on 2017/4/21.
 */
public class PerfectNumber {

    //Just check from 2 to square root.
    public boolean checkPerfectNumber(int num) {
        //num == 1 is special case.
        if(num == 1) return false;
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                if(i == num/i) sum+=i;
                else sum = sum+i+num/i;
            }
        }
        return sum == num;
    }
}
