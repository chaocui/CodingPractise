package leetcode.medium;

/**
 * Created by cc on 2017/3/13.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int j = 0; j < sb.length; j++) sb[j] = new StringBuilder();
        char[] c = s.toCharArray();
        int length = s.length();
        int i = 0;
        while(i < length){
            //Going down
            for(int index = 0; index < numRows && i < length; index++)
                sb[index].append(c[i++]);
            //Going up, only take from row - 2 to 1;
            for(int index = numRows - 2; index >= 1 && i < length; index--)
                sb[index].append(c[i++]);
        }
        for(int index = 1; index < numRows; index++)
            sb[0].append(sb[index]);
        return sb[0].toString();
    }


    //1. First row, interval is 2(N-i); i is the row number
    //2. Last row, interval is 2(i - 1);
    //3. any row between, odd number 2(N-i), via route from bottom. even number 2(i-1), via route from top.
    public String convertII(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numRows; i++){
            int index = i-1;
            if(i == 1){
                while(index < s.length()){
                    sb.append(s.charAt(index));
                    index = index + 2*(numRows - i);
                }
            }
            if(i == numRows){
                while(index < s.length()){
                    sb.append(s.charAt(index));
                    index = index + 2*(i - 1);
                }
            }
            else{
                int count = 1;
                while(index < s.length()){
                    sb.append(s.charAt(index));
                    if(count % 2 == 1) index = index + 2*(numRows - i);
                    else index = index + 2*(i - 1);
                    count ++;
                }
            }
        }
        return sb.toString();
    }

}
