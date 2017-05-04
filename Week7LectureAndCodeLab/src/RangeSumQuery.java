/**
 * Created by liukx08 on 5/4/2017.
 */
public class RangeSumQuery {
    SegTreeNode root;

    class SegTreeNode {
        int start;
        int end;
        SegTreeNode left;
        SegTreeNode right;
        int sum;
        public SegTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    public RangeSumQuery(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        root = build(nums, 0, nums.length - 1);
    }

    private SegTreeNode build(int[] nums, int start, int end) {
        if(start == end) {
            return new SegTreeNode(start, end, nums[start]);
        }
        int mid = (start + end) >>> 1;
        SegTreeNode left = build(nums, start, mid);
        SegTreeNode right = build(nums, mid + 1, end);
        SegTreeNode root = new SegTreeNode(start, end, left.sum + right.sum);
        root.left = left;
        root.right = right;
        return root;
    }

    public void update(int i, int val) {
        if(root == null || i < root.start || i > root.end) {
            return;
        }
        update(root, i, val);
    }

    private void update(SegTreeNode root, int i, int val) {
        if(root.start == root.end) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) >>> 1;
        if(mid >= i) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        if(root == null || i < root.start || j > root.end) {
            return 0;
        }
        return sumRange(root, i, j);
    }

    private int sumRange(SegTreeNode root, int i, int j) {
        if(root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = (root.start + root.end) >>> 1;
        if(mid >= j) {
            return sumRange(root.left, i, j);
        }
        if(mid < i) {
            return sumRange(root.right, i, j);
        }
        return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
    }

    public static void main(String[] args) {
        RangeSumQuery test = new RangeSumQuery(new int[]{1,3,2,7,9,2,8});
        System.out.println(test.sumRange(0,6));
        System.out.println(test.sumRange(2,5));
        System.out.println(test.sumRange(6,6));
        System.out.println(test.sumRange(3,6));
        test.update(3,-1);
        System.out.println(test.sumRange(0,6));
        System.out.println(test.sumRange(2,5));
        System.out.println(test.sumRange(6,6));
        System.out.println(test.sumRange(3,6));
    }
}
