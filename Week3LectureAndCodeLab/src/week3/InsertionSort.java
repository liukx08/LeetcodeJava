package week3;

/**
 * Created by liukx08 on 4/7/2017.
 */
public class InsertionSort {
    public int[] insertionSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int j=0;
            int tmp=nums[i];
            while(nums[j]<nums[i])j++;
            System.arraycopy(nums, j, nums,j+1,i-j);
            nums[j]=tmp;
        }
        return nums;
    }
}
