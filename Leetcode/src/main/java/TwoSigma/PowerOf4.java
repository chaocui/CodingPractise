package TwoSigma;

/**
 * Created by cc on 2016/8/14.
 */
public class PowerOf4 {

    public boolean po4(int x){

        if(x == 0){
            return false;
        }

        if(x == 1){
            return true;
        }

        if(x%4 == 0){
            return po4(x/4);
        }
        else{
            return false;
        }
    }

    public boolean po4Bit(int x){
        if(x == 0){
            return false;
        }
        if((x&(x-1)) == 0){
            int numOf0 = 0;
            while((x&1) != 1){
                x = x >> 1;
            }
            return numOf0 % 2 == 0;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        PowerOf4 po4 = new PowerOf4();
        System.out.println(po4.po4Bit(4));
        System.out.println(po4.po4Bit(0));
        System.out.println(po4.po4Bit(1));
        System.out.println(po4.po4Bit(9));
        System.out.println(po4.po4Bit(16));
    }
}

