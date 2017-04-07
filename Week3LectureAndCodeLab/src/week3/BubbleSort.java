package week3;

/**
 * Created by liukx08 on 4/7/2017.
 */
public class BubbleSort {
    public int[] bubbleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1])swap(nums,j-1,j);
       //         for(int l=0;l<nums.length;l++)System.out.print(nums[l]);
       //         System.out.println("");
            }
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public void test(){
        int[] nums=new int[]{3,5,1,7,2,8,4,6};
        for (int num1 : nums) System.out.print(num1);
        System.out.println("");
        nums=bubbleSort(nums);
        for (int num : nums) System.out.print(num);
        System.out.println("");
    }
}
