package leetcode.medium;


import java.util.Queue;

/**
 * Created by cc on 2017/3/12.
 */
public class AmazonTest
{
    public static int totalScore(String[] blocks, int n)
    {
        int sum = 0;
        int lastIndex = 0;
        for(int i = 1; i < n; i++){
            String temp = blocks[i];
            if("X".equals(temp)){
                blocks[i] = Integer.parseInt(blocks[lastIndex])*2 + "";
                if(lastIndex + 1 != i) lastIndex = i;
                else lastIndex++;
                sum = sum + Integer.parseInt(blocks[i]);
            }
            else if("+".equals(temp)){
                if(lastIndex <= 0){
                    blocks[i] = "0";
                }
                else if(lastIndex == 1){
                    blocks[i] = Integer.parseInt(blocks[lastIndex - 1])+"";
                }
                else{
                    blocks[i] = "" + (Integer.parseInt(blocks[lastIndex]) + Integer.parseInt(blocks[lastIndex-1]));
                }
                if(lastIndex + 1 != i) lastIndex = i;
                else lastIndex++;
            }
            else if("Z".equals(temp)){
                sum = sum - Integer.parseInt(blocks[lastIndex]);
                if(lastIndex - 1 < 0) lastIndex = 0;
                else lastIndex --;
            }
            else{
                sum = sum + Integer.parseInt(blocks[i]);
                if(lastIndex + 1 != i) lastIndex = i;
                else lastIndex++;
            }
        }
        return sum;
        // WRITE YOUR CODE HERE
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args){
        AmazonTest at = new AmazonTest();
        String[] test = {"5","-2","4","Z","X","9","+","+"};
        System.out.println(AmazonTest.totalScore(test, 8));
    }
}
