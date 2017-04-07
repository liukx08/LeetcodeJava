package week3;

/**
 * Created by liukx08 on 4/7/2017.
 */
public class SelectionSort {
    public int[] selectionSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int smallest=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[smallest])smallest=j;
            }
            swap(nums,i,smallest);
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
