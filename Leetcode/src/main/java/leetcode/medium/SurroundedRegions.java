package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2016/7/18.
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        int rows = board.length;
        if(rows < 3){
            return ;
        }
        int cols = board[0].length;
        if(cols < 3){
            return ;
        }
        //Up & down rows
        for(int i = 0; i < cols; i ++){
            dfsIt(board, rows, cols, 0, i);
            dfsIt(board, rows, cols, rows-1, i);
        }

        //left & right columns
        for(int i = 1; i < rows-1; i++){
            dfsIt(board, rows, cols, i, 0);
            dfsIt(board, rows, cols, i, cols-1);
        }

        for(int i  = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private class Position{

        int i, j;
        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    //If not consider time, simplest way
    //If consider, use stack to do dfs
    private void dfs(char[][] board, int numRows, int numCols, int row, int col){
        if(row < 0 || row >= numRows || col < 0 || col >= numCols || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'Y';
        //up
        dfs(board, numRows, numCols, row-1, col);
        //down
        dfs(board, numRows, numCols, row+1, col);
        //left
        dfs(board, numRows, numCols, row, col-1);
        //right
        dfs(board, numRows, numCols, row, col+1);
    }

    //can also do bfs
    private void bfs(char[][] board, int numRows, int numCols, int row, int col){
        if(row < 0 || row >= numRows || col < 0 || col >= numCols || board[row][col] != 'O'){
            return;
        }

        Queue<Position> q = new LinkedList<Position>();
        Position p = new Position(row, col);
        q.offer(p);

        while(!q.isEmpty()){
            Position temp = q.poll();
            int i = temp.i, j = temp.j;
            board[i][j] = 'Y';
            //up
            if(i - 1 >= 0 && board[i-1][j] == 'O'){
                q.offer(new Position(i-1, j));
            }
            //down
            if(i + 1 < numRows && board[i+1][j] == 'O') {
                q.offer(new Position(i + 1, j));
            }
            //left
            if(j - 1 >= 0 && board[i][j-1] == 'O') {
                q.offer(new Position(i, j - 1));
            }
            //right
            if(j + 1 < numCols && board[i][j+1] == 'O') {
                q.offer(new Position(i, j + 1));
            }
        }
    }

    private void dfsIt(char[][] board, int numRows, int numCols, int row, int col){
        if(row < 0 || row >= numRows || col < 0 || col >= numCols || board[row][col] != 'O'){
            return;
        }

        Stack<Position> q = new Stack<Position>();
        Position p = new Position(row, col);
        q.push(p);

        while(!q.isEmpty()){
            Position temp = q.peek();
            int i = temp.i, j = temp.j;
            board[i][j] = 'Y';
            q.pop();
            //up
            if(i - 1 >= 0 && board[i-1][j] == 'O'){
                q.push(new Position(i-1, j));
            }
            //down
            if(i + 1 < numRows && board[i+1][j] == 'O') {
                q.push(new Position(i + 1, j));
            }
            //left
            if(j - 1 >= 0 && board[i][j-1] == 'O') {
                q.push(new Position(i, j - 1));
            }
            //right
            if(j + 1 < numCols && board[i][j+1] == 'O') {
                q.push(new Position(i, j + 1));
            }
        }
    }

    public static void main(String[] args){
        char[][] test = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};

        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(test);
        int rows = test.length;
        int cols = test[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(test[i][j]);
            }
            System.out.println();
        }
    }
}
