package leetcode.easy;

/**
 * Created by cc on 2017/4/19.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int result = 0;
        for(int i =  2; i < notPrime.length; i++){
            //if it is not not a prime, it is a prime
            if(!notPrime[i]){
                result ++;
                //see what can be formed using current prime < n
                for(int j = 2; i*j < n; j++){
                    notPrime[i*j] = true;
                }
            }
        }
        return result;
    }

}
