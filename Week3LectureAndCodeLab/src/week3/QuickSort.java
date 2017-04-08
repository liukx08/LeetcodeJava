package week3;

/**
 * Created by liukx08 on 4/8/2017.
 */
public class QuickSort {
    public int[] quickSort(int[] nums){
        if(nums==null||nums.length==0)return nums;
        doSort(nums,0,nums.length-1);
        return nums;
    }

    private void doSort(int[] nums,int start,int end){
        if(start>=end)return;
        int idx=partition(nums,start,end);
        doSort(nums,start,idx-1);
        doSort(nums,idx+1,end);
    }

    private int partition(int[] nums,int start,int end){
        int r=start+(int)Math.random()*(end-start+1); // random() return a 0.0 <= double < 1.0
        int pivot=nums[r];
        swap(nums,r,end);
        int i=start,j=start;
        while(j<=end){
            if(nums[j]<pivot)swap(nums,i++,j);
            j++;
        }
        swap(nums,i,end);
        return i;
    }

    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
