/**
 * Created by liukx08 on 5/4/2017.
 */
public class BinaryIndexedTree {
    int[] nums;
    int[] bit;

    public BinaryIndexedTree(int[] nums) {
        this.nums = nums;
        this.bit = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            add(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        add(i, diff);
    }

    public int sumRange(int i, int j) {
        return getNum(j) - getNum(i - 1);
    }

    public void add(int i, int val) {
        for(int j = i + 1; j <= nums.length; j += j & (~j + 1)) {
            bit[j] += val;
        }
    }

    public int getNum(int i) {
        int sum = 0;
        for(int j = i + 1; j > 0; j -= j & (~j + 1)) {
            sum += bit[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryIndexedTree test = new BinaryIndexedTree(new int[]{1,3,2,7,9});
        System.out.println(test.sumRange(0,4));
        System.out.println(test.sumRange(1,3));
        System.out.println(test.sumRange(2,2));
        test.update(2, -1);
        System.out.println(test.sumRange(0,4));
        System.out.println(test.sumRange(1,3));
        System.out.println(test.sumRange(2,2));
    }
}