package leetcode.Snapchat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/18.
 */
public class FindAllPrimeLessThanN {

    /**
     * Key is we can find all non-prime numbers that less than n.
     *
     * */
    public List<Integer> findPrimes(int n){
        boolean[] notPrime = new boolean[n+1];
        List<Integer> result = new ArrayList<>();
        for(int i = 2; i < notPrime.length; i++){
            //if it is prime.
            if(!notPrime[i]){
                result.add(i);
                for(int j = 2; i*j <= n; j++)
                    notPrime[i*j] = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllPrimeLessThanN fapln = new FindAllPrimeLessThanN();
        List<Integer> result = fapln.findPrimes(20);
        for(int i : result)
            System.out.println(i);
    }
}
