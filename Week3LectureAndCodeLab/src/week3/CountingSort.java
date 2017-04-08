package week3;

/**
 * Created by liukx08 on 4/8/2017.
 */
public class CountingSort {
    public int[] countingSort(int nums[]){
        if(nums==null||nums.length==0)return nums;
        int min=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){         // find min value and max value
            if(nums[i]<min)min=nums[i];
            if(nums[i]>max)max=nums[i];
        }
        int[] count=new int[max-min+1];         // count the frequency of each value
        for(int i=0;i<nums.length;i++){
            count[nums[i]-min]++;
        }
        for(int i=1;i<count.length;i++){        // cumulative frequency (ending index)
            count[i]+=count[i-1];
        }
        int[] res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){      // copy elements to corresponding index in int from nums
            res[--count[nums[i]-min]]=nums[i];
        }
        return res;
    }
}
