package leetcode.easy;

/**
 * Created by cc on 2017/5/28.
 */
public class SqrtX {

    /**
     * return a integer.
     * so when we do binary search,
     * if mid * mid <= x && mid+1)(mid+1) > x we return mid.
     * */
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int l = 1, r = x;
        while(true){
            int mid = l + (r-l)/2;
            //here we use mid > x/mid. this is because if use mid*mid > x
            //mid*mid might potentially cause integer overflow.
            if(mid > x / mid)
                r = mid - 1;
            else{
                if((mid+1)> x/(mid+1) )
                    return mid;
                l = mid+1;
            }
        }
    }

}
