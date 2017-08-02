package leetcode.Linkedin;

/**
 * Created by cc on 2017/6/25.
 */
public class CanPlaceFlowers {

    /**
     * Pattern
     *
     * two 1s if there are 1 or 2 0s between them cannot plant anything,
     * if there are 3,4, can plant 1, 5,6 plant 2.
     * if there n 0s,
     * can plant (n-1)/2
     *
     * special case, beginning and the end, two spaces can plant 1.
     * */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /**
         * We set starting at -2.
         * so that end - start - 1 can be a normal equation to calculate number of zeros.
         * */
        int start = -2;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                n = n - (i - start - 1 - 1)/2;
                start = i;
            }
        }
        //we also need to handle the trailing zeros.
        //same as start, trailing 2,3 can plant 1, 4,5 can plant 2.
        //so (flowerbed.length - start - 1) is how many zeros. then divide 2.
        n = n - (flowerbed.length - start - 1)/2;
        return n <= 0;
    }

}
