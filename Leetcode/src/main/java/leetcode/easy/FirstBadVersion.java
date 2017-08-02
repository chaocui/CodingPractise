package leetcode.easy;

/**
 * Created by cc on 2017/4/20.
 */
public class FirstBadVersion {

    //binary call .
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while(start <= end){
            //Write code like this to prevent overflow!!!!!!!!!
            //wooow, just figured out.cool
            int mid = start + (end - start)/2;
            if(isBadVersion(mid) && ((mid == 1) || !isBadVersion(mid-1))) return mid;
            else if(isBadVersion(mid))
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
    public int firstBadVersion1(int n) {
        int start = 1, end = n;
        while(start < end){
            //Write code like this to prevent overflow!!!!!!!!!
            //wooow, just figured out.cool
            int mid = start + (end - start)/2;
            if(!isBadVersion(mid)) start = mid+1;
            //since if it is bad version. has possibility to be the first one,
            //Cannot abundant it.
            else end = mid;
        }
        return start;
    }

    private boolean isBadVersion(int version){
        return true;
    }

}
