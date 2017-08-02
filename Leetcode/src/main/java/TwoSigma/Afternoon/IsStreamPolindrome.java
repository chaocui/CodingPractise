package TwoSigma.Afternoon;

/**
 * Created by cc on 2016/8/27.
 *
 *
 * Rabin-Karp Algorithm.
 *
 * Basically, instead of comparing each substring
 * Rabin-Karp stores hash value of pattern and each substring.
 * Hash Value of each substring is a integer.
 * So comparison will be faster than compare string.
 *
 * Since hash function is not perfect, so if hash value are the same, need to double check the substring again to make sure they are the same.
 *
 * Key part is find relative good hash function and next hash value has to be simple to be calculated based on previous hash value.
 * Basic idea is
 * hash(s+1, s+m) = s*prime^(m-1) + (s+1)*prime^(m-2) + ... + (s+m)*prime^(0)
 * hash(s+1, s+m) = prime*(hash(s, s+m-1) - s*prime^(m-1)) + (s+m);
 * previous equation means that hash value - first hash value, then the result multiply by prime, plus the new value.
 *
 * prime is usually a prime number, relative big.
 * For certain m and m is small, it is ok to calculate this pow(prime, m-1)
 *
 * But is m is big or m increase, it is impossible, so we take mod of prime.
 * h = d^(m-1)%prime
 * d is the number of characters in pattern usually it is 256.
 *
 * so hash(s+1, s+m) = s*d^(m-1)%prime + (s+1)*d^(m-2)%prime + ... + (s+m)*d^(0)%prime
 *
 * Also d^(m-1)%prime = ((d%prime)*d%prime)*d%prime......
 *
 * So
 * d^(m-1)%prime is
 * int h = 1
 * for(int i = 0; i < m-1; i++){
 *     h = (h*d)%prime;
 * }
 *
 */
public class IsStreamPolindrome {

    public final int d = 256;
    public final int p = 97;

    public void isPalindrome(char[] c){

        System.out.println("true");

        int h = 1;
        int reverseFirstHalfHash = c[0]%p;
        int secondHalfHash = c[1]%p;
        for(int i = 1; i < c.length; i++){
            //Without hash check, this is the simple solution.
            //Just check each substring see if they are palindrome.
            if(reverseFirstHalfHash == secondHalfHash){
                int j = 0;
                for(j = 0; j < i/2; j++){
                    if(c[j] != c[i-j]){
                        break;
                    }
                }
                //If reach the end,
                if(j==i/2){
                    System.out.println(true);
                }
                //If break;
                else{
                    System.out.println(false);
                }
            }
            else{
                System.out.println(false);
            }

            //Update hash, don't update if reach the end
            if(i!=c.length-1){
                //if i is even, next i is odd, so length is even.
                //So first half and second half both + new next hash value
                if(i%2==0){
                    h = (h*d)%p;
                    reverseFirstHalfHash = (reverseFirstHalfHash + c[i/2]*h)%p;
                    secondHalfHash = (d*secondHalfHash + c[i+1])%p;
                }
                //if i is odd, next i is even, so length is odd.
                //So first half does not change.
                //Second half minus the first, plus the new one
                else{
                    secondHalfHash = (d*(secondHalfHash - c[(i+1)/2]*h)%p + c[i+1] + p)%p;
                }
            }
        }
    }
}
