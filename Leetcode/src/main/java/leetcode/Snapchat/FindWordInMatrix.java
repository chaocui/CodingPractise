package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/18.
 */
public class FindWordInMatrix {

    /**
     * DFS + back tracing.
     * */
    public boolean find(String s, char[][] matrix){
        if(s == null || s.length() == 0) return false;
        char c = s.charAt(0);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == c){
                    if(getResult(1, s, matrix, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean getResult(int start, String s, char[][] matrix, int r, int c){
        if(start == s.length())
            return true;

        int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        char nextChar = s.charAt(start);
        for(int i = 0; i < d.length; i++){
            int x = r + d[i][0];
            int y = c + d[i][1];
            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == nextChar){
                matrix[x][y] = '#';
                if(getResult(start+1, s, matrix, x, y))
                    return true;
                matrix[x][y] = nextChar;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','c','d'},{'a','b','c','d'},{'a','b','c','d'},{'a','b','c','d'}};
        FindWordInMatrix fwim = new FindWordInMatrix();
        System.out.println(fwim.find("abccddcdbaa", matrix));
    }

}
