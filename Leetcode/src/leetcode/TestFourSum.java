package leetcode;

import java.util.List;

public class TestFourSum {
	public static void testDemo(){
		int[] nums=new int[]{-1,0,1,2,-1,-4};
		List<List<Integer>> res=FourSum.fourSum(nums,-1);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).toString());
		}
	}
}
