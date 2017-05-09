/**
 * Created by liukx08 on 5/9/2017.
 */
public class FindMinRotatedSortedArrayII_154 {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) >>> 1;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else if(nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}
