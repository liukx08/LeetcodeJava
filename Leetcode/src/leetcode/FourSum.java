package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums,int target){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int max=nums[nums.length-1];
		for(int i=0;i<nums.length-3;i++){
			if(i>0&&nums[i]==nums[i-1])continue;
			if(nums[i]+3*max<target)continue;
			if(4*nums[i]>target)break;
			if(4*nums[i]==target){
				if(i+3<nums.length&&nums[i+3]==nums[i])result.add(Arrays.asList(nums[i],nums[i],nums[i],nums[i]));
				break;
			}
			threeSum(result,nums,i+1,nums.length-1,target-nums[i],nums[i]);
		}
		return result;
	}
	
	private static void threeSum(List<List<Integer>> res,int[] nums,int low, int high,int target,int x){
		if(low+2>high)return;
		int max=nums[high];
		if(3*nums[low]>target||3*nums[high]<target)return;
		for(int i=low;i<=high-2;i++){
			if(i>low&&nums[i]==nums[i-1])continue;
			if(nums[i]+2*max<target)continue;
			if(3*nums[i]>target)break;
			if(3*nums[i]==target){
				if(i+2<=high&&nums[i+2]==nums[i]){
					res.add(Arrays.asList(x,nums[i],nums[i],nums[i]));
					break;
				}
			}
			twoSum(res,nums,i+1,high,target-nums[i],x,nums[i]);
		}
	}
	
	private static void twoSum(List<List<Integer>> res,int[] nums,int low, int high,int target,int x1,int x2){
		if(low>=high)return;
		if(2*nums[low]>target||2*nums[high]<target)return;
		int i=low,j=high,sum;
		while(i<j){
			sum=nums[i]+nums[j];
			if(sum==target){
				res.add(Arrays.asList(x1,x2,nums[i],nums[j]));
				while(++i<j&&nums[i]==nums[i-1]);
				while(i<--j&&nums[j]==nums[j+1]);
			}
			if(sum<target)i++;
			if(sum>target)j--;
		}
		return;
	}
}

