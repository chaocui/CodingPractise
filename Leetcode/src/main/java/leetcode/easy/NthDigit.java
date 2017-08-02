package leetcode.easy;

/**
 * Created by cc on 2017/4/20.
 */
public class NthDigit {
    //find the number where the NthDigit is from.
    //idea is n > i*j*9  then i*=10, j+=1; until break loop;
    //then remaining / j + i - 1 is the number it is from.
    //then transfer to string get the number.
    public int findNthDigit(int n) {
        long i = 1, j = 1;
        long m = (long)n;
        while(m > i*j*9){
            m = m - i*j*9;
            i = i*10;
            j++;
        }
        long number = i + m/j - 1;
        if(m % j == 0) return (int)number%10;
        StringBuilder sb = new StringBuilder((number + 1) + "");
        return sb.charAt((int)(m%j-1))-'0';
    }

    public static void main(String[] args) {
        NthDigit nd = new NthDigit();
        System.out.println(nd.findNthDigit(1000000000));
    }
}
