package leetcode.medium;

/**
 * Created by cc on 2016/7/13.
 */
public class CountingBits {

    public int[] count(int num){

        int[] result = new int[num+1];
        result[0] = 0;
        if(num == 0)
            return result;

        int i = 0;
        boolean done = false;
        while(true){
            for(int j = 0; j < Math.pow(2, i); j++){
                int next = j+(int)((Math.pow(2, i)));
                if(next > num || j > num) {
                    done = true;
                    break;
                }
                else{
                    result[j+(int)((Math.pow(2, i)))] = result[j] + 1;
                }
            }
            if(done){
                break;
            }
            i++;
        }
        return result;
    }

    public int[] countBits(int num){
        int[] result = new int[num+1];
        result[0] = 0;
        if(num == 0)
            return result;

        int j = 0;
        for(int i = 1; i <= num; i++){

            int secStart = (int)Math.pow(2,j);
            int secEnd = (int)Math.pow(2, j+1);

            if(i >= secStart && i < secEnd){
                result[i] = result[i - secStart] + 1;
            }
            else{
                j++;
                i--;
            }
        }

        return result;
    }

    public int[] countBitss(int num){
        int[] result = new int[num+1];
        result[0] = 0;
        if(num == 0)
            return result;
        int j = 1;
        for(int i = 1; i <= num; i++){
            int secStart = j;
            int secEnd = 2*j;

            if(i >= secStart && i < secEnd){
                result[i] = result[i - secStart] + 1;
            }
            else{
                j = secEnd;
                i--;
            }
        }
        return result;
    }
}
