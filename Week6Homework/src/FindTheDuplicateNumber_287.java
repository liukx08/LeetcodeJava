/**
 * Created by liukx08 on 5/1/2017.
 *
 *      this array index from 0 to n, value is from 1 to n. it is like a no value linked graph
 *      each element point to another element.
 *      1. each element must point to another element, no tail in this graph
 *      2. there is one circle at least
 *      3. since there is only on duplicate, all branches end with the same element in one circle
 *      4. no element point to 0, thus 0 is the head of one branch
 *
 *                     # -> # -> #
 *                     ^         v
 *                     #         #
 *                     ^         v
 *      # -> # -> # -> # <- # <- #
 *
 */
public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 2) {
            return -1;
        }
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        // fast runs the double speed of slow
        // if they start on the circle, they will meet at the starting point
        // when fast runs two circles while slow runs one
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // they start from the head of one branch, it is like the starting point
        // is from the crossing point by the length of the branch
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
