package Bloomberg;

/**
 * Created by cc on 2016/9/7.
 */
public class IntToString {

    public String intToString(int num){

        StringBuilder sb = new StringBuilder();
        while(num > 10){
            int each = num%10;
            num = num/10;
            sb.insert(0, each);
        }
        sb.insert(0,num);
        return sb.toString();
    }

    public static void main(String[] args){
        IntToString its = new IntToString();
        System.out.println(its.intToString(123));
    }

}
