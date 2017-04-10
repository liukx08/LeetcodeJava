/**
 * Created by liukx08 on 4/10/2017.
 */
public class MergeSort {
    public int[] mergeSort(int[] nums){
        doSort(nums,0,nums.length-1);
        return nums;
    }

    private void doSort(int[] nums,int start,int end){
        if(start>=end)return;
        int mid=(start+end)>>>1;
        doSort(nums,start,mid);
        doSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }

    private void merge(int[] nums,int start,int mid,int end){
        int[] helper=new int[nums.length];
        System.arraycopy(nums,0,helper,0,nums.length);
        int left=start,right=mid+1;
        for(int i=start;i<=end;i++){
            if(left>mid){
                nums[i]=helper[right++];
            }else if(right>end){
                nums[i]=helper[left++];
            }else if(helper[left]<=helper[right]){
                nums[i]=helper[left++];
            }else {
                nums[i]=helper[right++];
            }
        }
    }

    public static void main(String[] args){
        MergeSort test=new MergeSort();
        int[] nums=new int[]{2,1,7,4,5,9,3,6,8};
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
        nums=test.mergeSort(nums);
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
    }
}
