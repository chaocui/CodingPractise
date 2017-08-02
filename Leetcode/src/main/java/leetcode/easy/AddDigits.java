package leetcode.easy;

/**
 * Created by cc on 2016/3/29.
 */
public class AddDigits {
    public static int addDigits(int num) {
        String numString = Integer.toString(num);
        if(numString.length() == 1)
            return Integer.parseInt(numString);
        else{
            int result = 0;
            for(int i = 0; i < numString.length(); i++){
                result += Integer.parseInt(numString.charAt(i) + "");
            }
            return addDigits(result);
        }
    }

    public static int addDigits1(int num) {

        if(num < 10)
            return num;

        else{
            int result = 0;
            while(num > 0){
                result += num % 10;
                num = num / 10;
            }

            return addDigits1(result);
        }
    }

    public static void main(String[] args){
        System.out.println(addDigits1(10));
    }

}
