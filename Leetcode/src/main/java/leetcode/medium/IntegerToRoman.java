package leetcode.medium;

/**
 * Created by cc on 2016/8/6.
 */
public class IntegerToRoman {

    /**
     * Rule is same Character cannot repeat 3 times.
     * So the following pattern can be found
     * I ,II, III,
     * IV
     * V
     * VI, VII, VIII
     * IX
     * X
     * XI, XII, XIII,
     * XX, XXX
     * XL,
     * L
     * LX, LXX, LXXX
     * 1, 2, 3 can be construct by repeating 3 times.
     * 4 is special, 5 is special
     * 6, 7, 8 can be construct by V + I repeat 3 times.
     *
     * So can found several intervals
     * I, IV, V, IX, X, XL, L, XC, C, CD, D, DM, M
     * only treat minus as special case.
     * Other cases can eb handled using plus.
     *
     * */
    public String intToRoman(int num) {

        int nums[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 13; i++){
            int count = num/nums[i];
            num = num%nums[i];
            for(int j = 0; j < count; j++){
                result.append(romans[i]);
            }
        }
        return result.toString();
    }

}
