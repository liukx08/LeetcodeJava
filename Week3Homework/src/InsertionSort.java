/**
 * Created by liukx08 on 4/10/2017.
 */
public class InsertionSort {
    public int[] doSort(int[] nums){
        if(nums==null||nums.length==0)return nums;
        for(int i=0;i<nums.length;i++){
            int j=i-1;
            while(j>=0&&nums[j]>=nums[i])j--;
            int tmp=nums[i];
            System.arraycopy(nums,j+1,nums,j+2,i-j-1);
            nums[j+1]=tmp;
        }
        return nums;
    }

    public static void main(String[] args){
        InsertionSort test=new InsertionSort();
        int[] nums=new int[]{2,1,7,4,5,9,3,6,8};
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
        nums=test.doSort(nums);
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
    }
}
