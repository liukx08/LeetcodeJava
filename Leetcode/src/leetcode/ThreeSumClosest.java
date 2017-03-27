package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int low=i+1,high=nums.length-1;
            while(low<high){
            	int tmp=nums[i]+nums[low]+nums[high];
                if(Math.abs(tmp-target)<Math.abs(sum-target))sum=tmp;
                if(tmp-target==0)return sum;
                else if(tmp>target)high--;
                else low++;
            }
        }
        return sum;
    }
}
