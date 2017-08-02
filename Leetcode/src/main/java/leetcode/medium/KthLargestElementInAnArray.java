package leetcode.medium;

/**
 * Created by cc on 2017/1/24.
 */
public class KthLargestElementInAnArray {

    //Basically, instead of using heap.
    //Best solution is quick select.
    //All finding nth smallest, largest question can be solved in linear time.
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }

    //Same as quick sort,
    //Choose pivot as the right most,
    //Base on different sequence, partition.
    //Different part is quick sort, recursive do same thing in both partition.
    //Quick select only do the recursion in one partition.
    public int quickSelect(int[] a, int start, int end, int k){
        int pivot = a[end];
        int i = start, j = end;
        while(i < j){
            if(a[i] >= pivot){
                i++;
            }
            else if(a[i] < pivot){
                j--;
                swap(a,i,j);
            }
        }
        //at this point, i == j and a[j] > pivot
        swap(a, i, end);
        //now i is the position of pivot.
        if(i == k-1){
            return a[i];
        }
        //go right
        else if(i < k-1){
            return quickSelect(a, i+1, end, k);
        }
        //go left
        else{
            return quickSelect(a, start, i-1, k);
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        KthLargestElementInAnArray kleiaa = new KthLargestElementInAnArray();
        int[] test = {2,1};
        System.out.println(kleiaa.findKthLargest(test, 1));
    }

}
