/**
 * Created by liukx08 on 4/10/2017.
 */
public class QuickSort {
    public int[] quickSort(int[] nums){
        if(nums==null||nums.length==0)return nums;
        doSort(nums,0,nums.length-1);
        return nums;
    }

    private void doSort(int[] nums,int start,int end){
        if(start>=end)return;
        int select=(int)Math.random()*(end-start+1)+start;
        int pivot=nums[select];
        nums[select]=nums[end];
        nums[end]=pivot;
        int i=start;
        for(int j=start;j<=end;j++){
            if(nums[j]<=pivot){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
            }
        }
        doSort(nums,start,i-2);
        doSort(nums,i,end);
    }

    public static void main(String[] args){
        QuickSort test=new QuickSort();
        int[] nums=new int[]{2,1,7,4,0,5,9,3,6,8};
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
        nums=test.quickSort(nums);
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
    }
}
