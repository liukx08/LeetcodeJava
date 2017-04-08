package week3;

/**
 * Created by liukx08 on 4/7/2017.
 */
public class MergeSort {
    public int[] mergeSort(int[] nums){
        if(nums==null||nums.length==0)return nums;
        int[] helper=new int[nums.length];
        doSort(nums,helper,0,nums.length-1);
        return nums;
    }

    private void doSort(int[] nums,int[] helper,int start, int end){
        if(start>=end)return;
        int mid=(start+end)>>>1;
        doSort(nums,helper,start,mid);
        doSort(nums,helper,mid+1,end);
        merge(nums,helper,start,mid,end);
    }

    private void merge(int[] nums,int[] helper,int start,int mid,int end){
        System.arraycopy(nums,0,helper,0,nums.length);
        int a=start,b=mid+1;
        for(int i=start;i<=end;i++){
            if (a>mid){
                nums[i]=helper[b++];
            } else if (b>end){
                nums[i]=helper[a++];
            } else if (helper[b]<helper[a]){    // compare helper elements, helper is the copy of nums before sorting
                nums[i]=helper[b++];
            } else {
                nums[i]=helper[a++];
            }
        }
    }
}
