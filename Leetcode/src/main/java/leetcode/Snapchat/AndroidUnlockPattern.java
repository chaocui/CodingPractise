package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/18.
 */
public class AndroidUnlockPattern {

    /**
     * Several key points.
     * 1. Use a array to keep track of visited numbers.
     * 2. Use a skip array to keep which to numbers has skip value.
     *    if they dont have skip || the skip value is used, then we can keep recursion
     * */
    public int numberOfPatterns(int m, int n) {
        int result = 0;
        boolean[] visited = new boolean[10];
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        for(int i = m; i <= n; i++){
            /*
            * starting from 1, 2, 5.
            * meaning we use 1,2,5 already, then remaining is i - 1.
            */
            result += getResult(i-1, 1, visited, skip)*4;
            result += getResult(i-1, 2, visited, skip)*4;
            result += getResult(i-1, 5, visited, skip);
        }
        return result;
    }

    public int getResult(int remainning, int current, boolean[] visited, int[][] skip){
        if(remainning == 0) return 1;
        visited[current] = true;
        int result = 0;
        for(int i = 1; i <= 9; i ++){
            if(!visited[i] && (skip[current][i] == 0 || visited[skip[current][i]]))
                result += getResult(remainning-1, i, visited, skip);
        }
        visited[current] = false;
        return result;
    }
}
