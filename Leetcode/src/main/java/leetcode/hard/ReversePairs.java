package leetcode.hard;

/**
 * Created by cc on 2017/4/12.
 */
public class ReversePairs {

    int result = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return result;
    }

    public  void mergeSort(int[] nums, int start, int end){
        //base case, only one element, or start is on right side of end.
        if(end <= start)
            return;
        int mid = (start+end)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);

        //based on merge sort property,
        //left side and right side are sorted. so we can count the reverse paris.
        int count = 0;
        //logic here is.
        //if nums[l] > nums[r]*2, we move r, and add count, means current l has count number of reverse pairs.
        //otherwise, we move l to the right, and add current count to result.
        //check next l satisfy or not.
        //also if r > end, all following l are greater than previous l who has count reverse pairs,
        //so for all following l, we add the same count to the result.
        for(int l = start, r = mid+1; l <= mid;){
            //convert to long, since *2 may exceed integer max.
            if(r > end || (long)nums[l] <= 2*(long)(nums[r])){
                l++;
                result += count;
            }
            else{
                r++;
                count++;
            }
        }

        //Then do merge sort.
        //initialize temp array.
        int[] temp = new int[end-start+1];
        /**
         * This for loop is clever and neat.
         * break condition is either l <= mid || r <= end; so until all processed, wont stop.
         *
         * Thinking in this way:
         * when we use left number
         * 1. l <= mid, means still have l left to use.
         * 2. either no more right element, or l < r. SEQUENCE MATTERS!!!!!!!!!!!!!! OTHERWISE GET ArrayOutOfBoundary
         * check r > end first.
         * 1 && 2 we will take l,
         * otherwise we take r.
         *
         * So smart!!!!
         * */
        for(int l = start, r = mid+1, k = 0; l <=mid || r <= end;){
            if(l <= mid && (r > end || nums[l] < nums[r]))
                temp[k++] = nums[l++];
            else
                temp[k++] = nums[r++];
        }

        for(int i = 0; i < temp.length; i++)
            nums[start+i] = temp[i];
    }
}
