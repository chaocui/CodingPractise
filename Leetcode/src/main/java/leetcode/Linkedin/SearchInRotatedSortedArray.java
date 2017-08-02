package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/11.
 */
public class SearchInRotatedSortedArray {

    //no dups.
    /**
     * Basic idea is check which part is in sequence,
     * check if target is in this sequence, if in, go there, if not go the other side.
     * edge case is each side may have only one element, so one if statement need to check equal situations.
     * */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]) return mid;

            //left side in order
            if(nums[start] <= nums[mid]){
                //go left
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            //right side in order
            else{
                //go right
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        if(nums[start] == target) return start;
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {4,5,6,7,8,1,2,3};
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        System.out.println(sirsa.search(test, 8));
    }
}
