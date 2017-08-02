package leetcode.medium;

/**
 * Created by cc on 2016/7/24.
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {

        if(x+y == z || (x + y > z && z%gcd(x, y) == 0)) {
            return true;
        }
        return false;
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else return gcd(b, a%b);
    }
}
