package leetcode.medium;

import java.util.Stack;

/**
 * Created by cc on 2017/4/2.
 */
public class Minesweeper {

    //If click is M, then return.
    //if not, count number of mines.
    //if == 0, set to B, do all adjacent Es, push to stack.
    //else, set to number.

    //loop break condition.
    //once stack is empty.
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Stack<int[]> stack =  new Stack<>();
        stack.push(click);
        while(!stack.isEmpty()){
            int[] p = stack.pop();
            int px = p[0];
            int py = p[1];
            int count = 0;
            for(int i = 0; i < d.length; i++){
                int newX = px + d[i][0];
                int newY = py + d[i][1];
                if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                    if(board[newX][newY] == 'M' || board[newX][newY] == 'X')
                        count++;
                }
            }
            if(count != 0)
                board[px][py] = (char)(count + '0');
            else{
                board[px][py] = 'B';
                for(int i = 0; i < d.length; i++){
                    int newX = px + d[i][0];
                    int newY = py + d[i][1];
                    if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                        if(board[newX][newY] == 'E')
                            stack.push(new int[]{newX, newY});
                    }
                }
            }
        }
        return board;
    }

}
