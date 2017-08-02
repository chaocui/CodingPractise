package leetcode.Linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/7/11.
 */
public class LonelyPixelII {

    public int findBlackPixel(char[][] picture, int N) {

        String[] rowKey = new String[picture.length];
        List[] colKey = new ArrayList[picture[0].length];
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];

        for(int i = 0; i < picture.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < picture[0].length; j++){
                //create row key
                sb.append(picture[i][j]);
                if(picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                    //keep track of each column, which row is B
                    if(colKey[j] == null)
                        colKey[j] = new ArrayList<Integer>();
                    colKey[j].add(i);
                }
            }
            rowKey[i] = sb.toString();
        }

        int result = 0;
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B' && row[i] == N && col[j] == N){
                    List<Integer> l = colKey[j];
                    int m = 0;
                    for(; m < l.size(); m++){
                        if(!rowKey[l.get(m)].equals(rowKey[i]))
                            break;
                    }
                    if(m == l.size()) result ++;
                }
            }
        }
        return result;
    }


    /**
     * faster tricky solution.
     * 1 find the rows that has N black pixels, count same keys
     * 2 if same key has N, means that the black pixels in each row, the column also has N black pixels. fit rule 1.
     * 3 for each such key, check black pixel columns, if that column has N black pixels, add to count.
     *
     * result will be rowCount * colCount
     * */
}
