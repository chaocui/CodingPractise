package leetcode.Facebook;

/**
 * Created by cc on 2017/6/3.
 */
public class KthLargestElementInAnArray {

    //Heap is nlog(k)
    //Quick select will be O(n)
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length-1);
    }

    public int quickSelect(int[] nums, int k, int start, int end){
        int pivot = nums[end];
        int pivotP = start, i = start;
        while(i < end){
            if(nums[i] > pivot){
                swap(nums, pivotP, i);
                pivotP++;
            }
            i++;
        }
        swap(nums, pivotP, end);
        if(pivotP == k-1) return nums[pivotP];
        //left
        if(pivotP > k-1) return quickSelect(nums, k, start, pivotP-1);
        //right
        else return quickSelect(nums, k, pivotP+1, end);
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] test = {2,1,3,4,5,7};
        KthLargestElementInAnArray kleia = new KthLargestElementInAnArray();
        System.out.println(kleia.findKthLargest(test, 6));
    }

}
