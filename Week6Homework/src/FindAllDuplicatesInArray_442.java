import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 5/1/2017.
 *      each element points to another element
 *      duplicates point to the same element
 *      scanner from the first, mark the sign bit of the pointed element
 *
 */
public class FindAllDuplicatesInArray_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            // change sign bit to 0
            int idx = (nums[i] & Integer.MAX_VALUE) - 1;
            if(nums[idx] < 0) {
                res.add(idx + 1);
            }
            // change sign bit to 1
            nums[idx] = nums[idx] | Integer.MIN_VALUE;
        }
        return res;
    }
}
