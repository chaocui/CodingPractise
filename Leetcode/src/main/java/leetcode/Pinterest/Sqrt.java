package leetcode.Pinterest;

/**
 * Created by cc on 2017/6/20.
 */
public class Sqrt {

    public int sqrt(int i){
        if(i == 0) return 0;
        int l = 0, r = i;
        while(true){
            int mid = l + (r-l)/2;
            if(mid > i/mid)
                r = mid - 1;
            else{
                if(mid + 1 > i / (mid + 1))
                    return mid;
                l = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.sqrt(10));
    }
}
