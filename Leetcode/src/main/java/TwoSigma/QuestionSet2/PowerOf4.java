package TwoSigma.QuestionSet2;

/**
 * Created by cc on 2016/8/28.
 */
public class PowerOf4 {

    public boolean isP4(long n){

        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n%4==0){
            return isP4(n/4);
        }
        return false;
    }

    //Proof
    public boolean isP4II(long n){
        return (n&(n-1)) == 0 && n%3 == 1;
    }

    public boolean isP4III(long n){
        return (n&(n-1)) == 0 && (n & 0x5555555555555555l) != 0;
    }

    public static void main(String[] args){
        PowerOf4 p = new PowerOf4();
        System.out.println(p.isP4III(64));
    }
}
