package leetcode.Facebook;

/**
 * Created by cc on 2017/5/31.
 */
public class FirstBadVersion {

    private boolean isBadVersion(int n){return true;}

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r){
            int mid = l + (r-l)/2;
            //if mid is bad, means either mid is result or result is on left, so make r = mid. cannot ignore mid.
            if(isBadVersion(mid))
                r = mid;
            else l = mid + 1;
        }
        return l;
    }

}
