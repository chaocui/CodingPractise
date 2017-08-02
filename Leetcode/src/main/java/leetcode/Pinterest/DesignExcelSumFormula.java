package leetcode.Pinterest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/7/4.
 */
public class DesignExcelSumFormula {

    int[][] board;
    Map<String, String[]> formula;
    //formula holds which cell has formula, if it has, then calculate.
    public DesignExcelSumFormula(int H, char W) {
        board = new int[H][W-'A'];
        formula = new HashMap<>();
    }
    public void set(int r, char c, int v) {
        StringBuilder cell = new StringBuilder();
        cell.append(c).append(r-1);
        //if exist, remove the formula
        if(formula.containsKey(cell.toString()))
            formula.remove(cell.toString());
        board[r-1][c-'A'] = v;
    }

    //if there is formula for this cell, calculate the formula and return.
    //otherwise, just return board value.
    public int get(int r, char c) {
        StringBuilder cell = new StringBuilder();
        cell.append(c).append(r-1);
        if(formula.containsKey(cell.toString()))
            return calSum(formula.get(cell.toString()));
        return board[r-1][c-'A'];
    }

    public int sum(int r, char c, String[] strs) {
        StringBuilder cell = new StringBuilder();
        cell.append(c).append(r-1);
        int result = calSum(strs);
        formula.put(cell.toString(), strs);
        return result;
    }

    private int calSum(String[] strs){
        int result = 0;
        for(String s : strs){
            if(s.indexOf(":") > 0){
                String[] sl = s.split(":");
                char left = sl[0].charAt(0);
                int top = sl[0].charAt(1) - '0';
                char right = sl[1].charAt(0);
                int bottom = sl[1].charAt(1) - '0';
                for(int i = top; i <= bottom; i++){
                    for(char j = left; j <= right; j++){
                        result += get(i, j);
                    }
                }
            }
            else{
                char[] cl = s.toCharArray();
                result += get(cl[1]-'0', cl[0]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DesignExcelSumFormula desf = new DesignExcelSumFormula(3, 'C');
        desf.sum(1,'A',new String[]{"A2:B3"});
        desf.set(2, 'A', 1);
        desf.set(2, 'B', 1);
        desf.set(3, 'B', 1);
        System.out.println(desf.get(1,'A'));
        desf.set(3, 'B', 3);
        System.out.println(desf.get(1,'A'));
        System.out.println(desf.get(2,'A'));
    }

}
