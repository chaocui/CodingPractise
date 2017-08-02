package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/11.
 */
public class LonelyPixelI {

    //two traverse.
    /**
     * First time track row and column count of Bs.
     * second time check each B is lonely or not.
     * */
    public int findLonelyPixel(char[][] picture) {
        int result = 0;
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++)
                if(picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                }
        }

        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B' && row[i] == 1 && col[j] == 1)
                    result ++;
            }
        }
        return result;
    }

}
