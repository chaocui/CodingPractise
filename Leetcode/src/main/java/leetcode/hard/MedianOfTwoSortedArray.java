package leetcode.hard;

/**
 * Created by cc on 2016/10/31.
 */
public class MedianOfTwoSortedArray {

    /**
     * For instance, length of a is 2, find the 6 in a,b.
     * 6/2 = 3 which exceed boundary of a.
     * So first 3 in b cannot be part of result
     * */

    public int medianOfTwoArray(int[] a, int[] b){
        int aL = a.length;
        int bL = b.length;
        if((aL+bL)%2 == 1){
            return kthElement(a, 0, b, 0, (aL+bL)/2+1);
        }
        else{
            return (kthElement(a,0,b,0,(aL+bL)/2) + kthElement(a,0,b,0,(aL+bL)/2+1))/2;
        }
    }

    public int kthElement(int[] a, int aStart, int[] b, int bStart, int k){
        //Abanden all elements from a.
        if(aStart >= a.length){
            return b[bStart+k-1];
        }

        //Abanden all elements from b.
        if(bStart >= b.length){
            return a[aStart+k-1];
        }

        if(k == 1){
            return Math.min(a[0],b[0]);
        }

        int A = (aStart + k/2 - 1) < a.length ? a[aStart + k/2 -1] : Integer.MAX_VALUE;
        int B = (bStart + k/2 - 1) < b.length ? b[bStart + k/2 -1] : Integer.MAX_VALUE;

        if(A<B){
            return kthElement(a, aStart+k/2, b, bStart, k-k/2);
        }
        else{
            return kthElement(a, aStart, b, bStart+k/2, k-k/2);
        }
    }


}
