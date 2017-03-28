package week1;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
	public List<String> summaryRanges(int[] nums) {
        List<String> summary=new ArrayList<String>();
        if(nums.length==0)return summary;
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-nums[start]!=i-start){
                if(i-start==1)summary.add(Integer.toString(nums[start]));
                else summary.add(Integer.toString(nums[start])+"->"+Integer.toString(nums[i-1]));
                start=i;
            }
        }
        if(start==nums.length-1)summary.add(Integer.toString(nums[start]));
        else summary.add(Integer.toString(nums[start])+"->"+Integer.toString(nums[nums.length-1]));
        return summary;
    }
}
