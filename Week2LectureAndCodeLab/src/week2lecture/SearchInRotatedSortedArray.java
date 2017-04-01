package week2lecture;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {	
        if(nums.length==0)return -1;
        if(nums.length==1)return nums[0]==target?0:-1;
        int low=0,n=nums.length,high=n-1,shift;
        while(low<high-1){
            shift=low+(high-low)/2;
            if(nums[shift]<nums[low])high=shift;
            else low=shift;
        }
        if(nums[low]<nums[high])shift=0;
        else shift=high;					// found the index of the smallest element
        low=0;
        high=n-1;
        int mid;
        while(low<high-1){
            mid=low+(high-low)/2;
            if(nums[(mid+shift)%n]==target)return (mid+shift)%n;
            else if(nums[(mid+shift)%n]<target)low=mid;
            else high=mid;
        }
        if(nums[(low+shift)%n]==target)return (low+shift)%n;
        else if(nums[(high+shift)%n]==target)return (high+shift)%n;
        else return -1;				// binary search, use shift and mod to get corresponding index in the rotated array
    }
    
    public int bettersearch(int[] nums, int target) {	// improved search method
        if(nums.length==0)return -1;
        if(nums.length==1)return nums[0]==target?0:-1;
        int low=0,n=nums.length,high=n-1,shift;
        while(low<high-1){
            shift=low+(high-low)/2;
            if(nums[shift]<nums[low])high=shift;
            else low=shift;
        }
        if(nums[low]<nums[high])shift=0;
        else shift=high;					// found the index of the smallest element
        if(shift==0){
        	low=0;
        	high=n-1;
        } else if(target<nums[0]) {
        	low=shift;
        	high=n-1;
        } else {
        	low=0;
        	high=shift-1;
        }							// determine which segment the target is in
        if(low==high){
        	if(target==nums[low])return low;
        	else return -1;
        }
        while(low<high-1){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]<target)low=mid;
            else high=mid;
        }
        if(nums[low]==target)return low;
        else if(nums[high]==target)return high;
        else return -1;				// binary search
    }
}
