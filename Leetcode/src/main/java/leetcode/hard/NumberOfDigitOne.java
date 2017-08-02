package leetcode.hard;

/**
 * Created by cc on 2016/11/6.
 */
public class NumberOfDigitOne {

    //For example:
    //case 1: certain position is 0  1234054, number of 1 1234*100
    //case 2: certain position is 1  1234154  number of 1 1234*100 + 54+1
    //case 3：certain position is >=2 1234654 number of 1 (1234+1)*100
    //So, 1234x54/100 = 1234x, --->
    //if x is 0, 1, it will be 1234*10, if x >=2 it will be 1234+1*10;
    //so (1234x+8)%10 satisfy previous conditions, because if x >=2 it will add one more to previous position
    //if x == 1, result + 1234x54%100 + 1；
    //So starting from 1, then every time multiply 10 as the dividend.
    public int countDigitOne(int n) {
        int result = 0;
        for(long scale = 1; scale <= n; scale*=10){
            long beforePlus1 = n/scale;
            long after = n % scale;
            result += (beforePlus1+8)/10*scale;
            if(beforePlus1%10 == 1){
                result += after + 1;
            }
        }
        return result;
    }

}
