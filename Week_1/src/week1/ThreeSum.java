package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
        	if(i==0||nums[i]!=nums[i-1]){
        		int low=i+1,high=nums.length-1;
        		while(low<high){
        			if(nums[low]+nums[high]==-nums[i]){
        				result.add(Arrays.asList(nums[i],nums[low],nums[high]));
        				while(low<high&&nums[low]==nums[low+1])low++;
        				while(nums[high]==nums[high-1]&&low<high)high--;
        				if(low<nums.length)low++;
        				high--;
        			}
        			else if(nums[low]+nums[high]<-nums[i])low++;
        			else high--;
        		}
        	}
        }
        return result;
    }
}
