import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.*;

/**
 * Created by liukx08 on 4/26/2017.
 */
public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public class IsValidBST implements Callable<Boolean> {
        TreeNode root;
        long minVal;
        long maxVal;
        ExecutorService executorService;

        public IsValidBST(ExecutorService executorService, TreeNode root, long minVal, long maxVal) {
            this.executorService = executorService;
            this.root = root;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }

        @Override
        public Boolean call() throws ExecutionException, InterruptedException {
            return isValidTree();
        }

        public Boolean isValidTree() throws ExecutionException, InterruptedException {
            if(root == null) {
                return true;
            }
            if(root.val >= maxVal || root.val <= minVal) {
                return false;
            }
            Thread.sleep(10);
            Future<Boolean> left = executorService.submit(new IsValidBST(executorService, root.left, minVal, root.val));
            Future<Boolean> right = executorService.submit(new IsValidBST(executorService, root.right, root.val, maxVal));
            return left.get() && right.get();
        }
    }

    public boolean isValidBST(TreeNode root) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        return isValidBST(executorService, root);
    }

    public boolean isValidBST(ExecutorService executorService, TreeNode root) {
        if(root == null) {
            return true;
        }

        IsValidBST isValidBSTCallable = new IsValidBST(executorService, root, Long.MIN_VALUE, Long.MAX_VALUE);
        try {
            return isValidBSTCallable.isValidTree();
        } catch(ExecutionException e) {
            e.printStackTrace();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

    public void printTreeLevel(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("[ ");
            while(size > 0) {
                TreeNode curr = queue.poll();
                System.out.print(curr.val);
                System.out.print(" ");
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
                size--;
            }
            System.out.println("]");
        }
        System.out.println("");
    }

    public void printTreeOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        System.out.print("[ ");
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val);
                System.out.print(" ");
                curr = curr.right;
            }
        }
        System.out.println("]");
        System.out.println("");
    }

    public boolean isValidT(TreeNode root) {
        return isValidT(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidT(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        try {
            if (root.val <= min || root.val >= max) {
                return false;
            }
            Thread.sleep(10);
            return isValidT(root.left, min, root.val) &&
                    isValidT(root.right, root.val, max);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[511];
        for(int i = 0; i < 511; i++) {
            nums[i] = i + 1;
        }
        ValidateBinarySearchTree test = new ValidateBinarySearchTree();
        TreeNode root = test.buildTree(nums, 0, 510);
        test.printTreeLevel(root);
        test.printTreeOrder(root);
        long start = System.currentTimeMillis();
        System.out.println(test.isValidT(root));
        long endS = System.currentTimeMillis();
        System.out.println(test.isValidBST(root));
        long endP = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Serial Execution Time: " + (endS - start));
        System.out.println("Parallel Execution Time: " + (endP - endS));
    }
}
