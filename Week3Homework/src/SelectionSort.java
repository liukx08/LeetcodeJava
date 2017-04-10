/**
 * Created by liukx08 on 4/10/2017.
 */
public class SelectionSort {
    public int[] doSort(int[] nums){
        if(nums==null||nums.length==0)return nums;
        int min;
        for(int i=0;i<nums.length;i++){
            min=i;
            for(int j=i+1;j<nums.length;j++){
                min=nums[j]<nums[min]?j:min;
            }
            int tmp=nums[i];
            nums[i]=nums[min];
            nums[min]=tmp;
        }
        return nums;
    }

    public static void main(String[] args){
        SelectionSort test=new SelectionSort();
        int[] nums=new int[]{2,1,7,4,5,9,3,6,8};
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
        nums=test.doSort(nums);
        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+" ");
        System.out.println("");
    }
}
