/**
 * Created by liukx08 on 4/30/2017.
 */
public class TrappingRainWater_42 {
    // two pointers moving from both sides towards center
    public int trap(int[] height) {
        if(height == null || height.length < 3) {
            return 0;
        }
        int leftMax = 0, rightMax = height.length - 1;
        int left = leftMax + 1, right = rightMax - 1;
        int res = 0;
        while(left <= right) {
            if(height[leftMax] < height[rightMax]) {
                if(height[leftMax] <= height[left]) {
                    leftMax = left++;
                } else {
                    res += (height[leftMax] - height[left++]);
                }
            } else {
                if(height[rightMax] <= height[right]) {
                    rightMax = right--;
                } else {
                    res += (height[rightMax] - height[right--]);
                }
            }
        }
        return res;
    }
}
