package leetcode;

import java.util.List;

public class TestThreeSum {
	public static void testDemo(){
		int[] nums=new int[]{0,0,0};
		List<List<Integer>> res=ThreeSum.threeSum(nums);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).toString());
		}
	}
}
