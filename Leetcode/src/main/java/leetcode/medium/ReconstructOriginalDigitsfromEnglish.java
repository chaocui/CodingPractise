package leetcode.medium;

import java.util.Map;

/**
 * Created by cc on 2017/3/28.
 */
public class ReconstructOriginalDigitsfromEnglish {

    //basic idea is find the pattern of these english characters.
    //for zero, two, four, six, eight.
    //they can be identified by one of their characters.

    //for others, starting from the least common characters with the previous 5.
    //so only four and five have f.
    //only eight and three have h.
    //only six and seven have s.
    //so that we can get the count of five, three and seven.

    //for others, we use character that only shows up once to identify.
    //for one, we use o to identify, since zero, two, four has one o.
    //for nine, we use five, eight, six to identify.
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c : s.toCharArray()){
            if(c == 'z') count[0]++;
            if(c == 'w') count[2]++;
            if(c == 'u') count[4]++;
            if(c == 'x') count[6]++;
            if(c == 'g') count[8]++;
            if(c == 'f') count[5]++;
            if(c == 'h') count[3]++;
            if(c == 'i') count[9]++;
            if(c == 's') count[7]++;
            if(c == 'o') count[1]++;
        }
        count[5] = count[5] - count[4];
        count[7] = count[7] - count[6];
        count[3] = count[3] - count[8];
        count[1] = count[1] - count[0] - count[2] - count[4];
        count[9] = count[9] - count[8] - count[6] - count[5];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.length; i++){
            int c = count[i];
            for(int j = 0; j < c; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

}
