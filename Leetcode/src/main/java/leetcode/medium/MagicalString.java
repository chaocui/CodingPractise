package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/3/30.
 */
public class MagicalString {

    /**
     * Basic idea is to use magic string to generate magic string.
     * initialize the magic string as 122.
     * and initialize the index at 2.
     * if n <= 0 return 0, n <=3 return 1;
     * k = 3
     * while(k < n) loop,
     * next count should be magicString.get(index).
     * we need to append count times of currentNumber,
     * if currentNumber is 1 we increase result.
     * Then we check if k == n+1 exceeding. if it is, check if currentNumber is 1 if it is we need to decrease by 1.
     *
     * Then we put k = k + count;
     * change currentNumber to 1 if it is 2, or 2 if it is 1.
     * then increase index to append more to the magic string.
     * */
    public int magicalString(int n) {
        List<Integer> magicalString = new ArrayList<Integer>();
        if(n <= 0) return 0;
        if(n <= 3) return 1;
        magicalString.add(1);
        magicalString.add(2);
        magicalString.add(2);
        int index = 2;
        int k = 3;
        int currentNumber = 1;
        int result = 1;
        while(k < n){
            int times = magicalString.get(index);
            for(int i = 0; i < times; i++) {
                magicalString.add(currentNumber);
                if(currentNumber == 1)
                    result++;
            }
            k = k + magicalString.get(index);
            //if k exceeding n, and currentNumber is 2, mea
            if(k == n + 1 && currentNumber == 1){
                result--;
            }
            currentNumber = currentNumber == 2 ? 1 : 2;
            index++;
        }
        return result;
    }

}
