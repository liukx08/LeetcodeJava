/**
 * Created by liukx08 on 5/4/2017.
 */
public class RangeMinQuery {
    SegTreeNode root;

    class SegTreeNode {
        int start;
        int end;
        SegTreeNode left;
        SegTreeNode right;
        int min;
        public SegTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
        }
    }

    public RangeMinQuery (int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    private SegTreeNode build(int[] nums, int start, int end) {
        if(start == end) {
            return new SegTreeNode(start, end, nums[start]);
        }
        int mid = (start + end) >>> 1;
        SegTreeNode left = build(nums, start, mid);
        SegTreeNode right = build(nums, mid + 1, end);
        int min = Math.min(left.min, right.min);
        SegTreeNode root = new SegTreeNode(start, end, min);
        root.left = left;
        root.right = right;
        return root;
    }

    public void update(int idx, int val) {
        if(root == null || idx < root.start || idx > root.end) {
            return;
        }
        SegTreeNode curr = root;
        while(curr != null) {
            if(val < curr.min) {
                curr.min = val;
            }
            int mid = (curr.start + curr.end) >>> 1;
            if(idx <= mid) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public int minRange(int i, int j) {
        if(root == null || i < root.start || j > root.end || i > j) {
            return -1;
        }
        return helper(root, i, j);
    }

    private int helper(SegTreeNode root, int i, int j) {
        if(i == root.start && j == root.end) {
            return root.min;
        }
        int mid = (root.start + root.end) >>> 1;
        if(mid >= j) {
            return helper(root.left, i, j);
        }
        if(mid < i) {
            return helper(root.right, i, j);
        }
        return Math.min(helper(root.left, i, mid), helper(root.right, mid + 1, j));
    }

    public static void main(String[] args) {
        RangeMinQuery test = new RangeMinQuery(new int[]{1,3,2,7,9,2,8});
        System.out.println(test.minRange(0,6));
        System.out.println(test.minRange(2,5));
        System.out.println(test.minRange(6,6));
        System.out.println(test.minRange(3,6));
        test.update(3,-1);
        System.out.println(test.minRange(0,6));
        System.out.println(test.minRange(2,5));
        System.out.println(test.minRange(6,6));
        System.out.println(test.minRange(3,6));
    }
}
