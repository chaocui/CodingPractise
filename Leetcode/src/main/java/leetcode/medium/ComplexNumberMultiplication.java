package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2017/4/5.
 */
public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        int[] aP = preProcess(a);
        int[] bP = preProcess(b);
        int integerPart = aP[0]*bP[0] - aP[1]*bP[1];
        int vPart = aP[0]*bP[1] + aP[1]*bP[0];
        return integerPart+"+"+vPart+"i";
    }

    public int[] preProcess(String s){
        int[] result = new int[2];
        StringBuilder sb = new StringBuilder();
        String[] parts = s.split("\\+");
        result[0] = Integer.parseInt(parts[0]);
        result[1] = Integer.parseInt(parts[1].substring(0,parts[1].length() - 1));
        return result;
    }

    public static void main(String[] args) {
        ComplexNumberMultiplication cnm = new ComplexNumberMultiplication();
        System.out.println(Arrays.toString(cnm.preProcess("15+-16i")));

    }

}
