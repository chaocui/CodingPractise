package leetcode.medium;

/**
 * Created by cc on 2016/7/16.
 */
public class CountingNumberWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {

        if(n == 0){
            return 1;
        }

        int[] result = new int[n+1];
        result[1] = 10;
        for(int i = 2; i <= n; i ++){
            result[i] = result[i-1] + newUnique(i);
        }
        return result[n];
    }

    private int newUnique(int n){
        int result = 1;
        int i = 0;
        while(n-1>0){
            result = result * (9-i);
            i++;
            n--;
        }
        return 9*result;
    }

    public static void main(String[] args){
       CountingNumberWithUniqueDigits cn = new CountingNumberWithUniqueDigits();
        System.out.println(cn.countNumbersWithUniqueDigits(3));
    }

}
