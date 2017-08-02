package leetcode.easy;

/**
 * Created by cc on 2016/4/9.
 */
public class ClimbStairs {

    public int ways(int steps){

        if(steps == 1)
            return 1;
        if(steps == 2)
            return 2;

        int[] results = new int[steps+1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;

        for(int i = 3; i <= steps; i++){
            results[i] = (results[i - 1]) + (results[i - 2]);
        }

        return results[steps];

    }

    public int ways1(int steps){

        if(steps == 1)
            return 1;
        if(steps == 2)
            return 2;

        return ways1(steps - 1) + ways(steps - 2);

    }

    public static void main(String[] args){
        ClimbStairs cs = new ClimbStairs();

        System.out.println(cs.ways(1));
        System.out.println(cs.ways(2));
        System.out.println(cs.ways(3));
        System.out.println(cs.ways1(4));

    }

}
