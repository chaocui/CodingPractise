package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/3/24.
 */
public class LexicographicalNumbers {

    /**
     * Find the next number, for example 45,
     * next can be 450, 45*10 and 45*10 <=n
     * next can be 46, if 45+1 <= n, but if 49, the next one is not 49+1. so 45%10 != 9 && 45 + 1 <= n
     *
     * special case
     * next can be 5, 45%10+1
     * if its 499 next one cannot be 499%10 + 1, which is 50, but 5 should be before 50.
     * So this case should be keep checking current % 10 == 9
     * if it is 9, we set current = current / 10;
     * until the remaining is not 9, we add 1.
     *
     * Conclusion:
     * either go down, or go right.
     * check go down first, since this will set current = current * 10;
     * then check go right, which has two situations.
     * 1. go right with + 1. which should satisfy the last digit is not 9, since if its 9, add 1 does not work
     * 2. handle the last one is 9,
     * if it is 9, we need to go one level up then go right.
     * we keep find the current which last digit is not 9, then add 1 to it.
     * */
    public List<Integer> lexicalOrder(int n) {
        int current = 1;
        List<Integer> result = new ArrayList<Integer>();
        //loop for n times to find n numbers.
        //starting from current = 1;
        for(int i = 0; i < n; i++){
            result.add(current);
            if(current * 10 <= n){
                current = current * 10;
            }
            else if(current % 10 != 9  && current + 1 <= n){
                current = current + 1;
            }
            /**
             * Logic here is,
             * if there is only one consecutive 9 starting from right.
             * While loop wont run,
             * current/10+1 will just remove the 9 and to to right at one level above.
             *
             * if there are more than 1 consecutive 9s.
             * like 567999
             * while loop always check if the previous number is 9 since at this step the last digits is always 9.
             * and the last one will be taken care by the following step. so check previous digit.
             * while loop will take away two 9s.
             * current will be 5679, and the following step current/10 + 1 will take away the last 9.
             * */
            else{
                while((current/10) % 10 == 9){
                    current = current / 10;
                }
                current = current/10 + 1;
            }
        }
        return result;
    }

}
