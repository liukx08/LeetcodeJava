package week2homework;

public class SearchInRotatedSortedArrayII_81 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0)return false;
        if(nums.length==1)return nums[0]==target?true:false;
        int low=0,n=nums.length,high=n-1,shift;
        while(low+1<=high&&nums[low+1]==nums[low])low++;	// exclude repeated elements at both end
        while(high-1>=low&&nums[high-1]==nums[high])high--; // exclude repeated elements at both end
        if(low==high)return nums[low]==target?true:false;	// followings are the same as the no-duplicate case
        while(low<high-1){
            shift=low+(high-low)/2;
            if(nums[shift]<nums[low])high=shift;
            else low=shift;
        }
        if(nums[low]<nums[high])shift=0;
        else shift=high;				
        if(shift==0){
        	low=0;
        	high=n-1;
        } else if(target<nums[0]) {
        	low=shift;
        	high=n-1;
        } else {
        	low=0;
        	high=shift-1;
        }							
        if(low==high){
        	if(target==nums[low])return true;
        	else return false;
        }
        while(low<high-1){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)return true;
            else if(nums[mid]<target)low=mid;
            else high=mid;
        }
        if(nums[low]==target)return true;
        else if(nums[high]==target)return true;
        else return false;
    }
}
