package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cc on 2016/8/7.
 */
public class WordSearch {

    //If non-recursive, need back tracing to update visited when one route does not work
    //So recursive will be easier to write
    public boolean exist(char[][] board, String word) {

        if(board == null || word.length() == 0){
            return false;
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(i,j,board,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(int x, int y, char[][] board, int p, String word){

        if(p < word.length() && (x < 0 || x > board.length-1 || y < 0 || y > board[0].length-1 || board[x][y] != word.charAt(p))){
            return false;
        }

        if(p == word.length() - 1 && word.charAt(p) == board[x][y]){
            return true;
        }

        char c = board[x][y];
        board[x][y] = '#';
        if(find(x-1,y,board,p+1,word)) return true;
        if(find(x+1,y,board,p+1,word)) return true;
        if(find(x,y-1,board,p+1,word)) return true;
        if(find(x,y+1,board,p+1,word)) return true;
        board[x][y] = c;
        return false;
    }

    public static void main(String[] args){
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        char[][] board1 = new char[][]{
                {'a', 'a'}
        };

        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCESEEEFS"));
    }

}
