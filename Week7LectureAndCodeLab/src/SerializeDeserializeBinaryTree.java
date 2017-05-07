import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by liukx08 on 5/7/2017.
 */
public class SerializeDeserializeBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class CharTreeNode {
        char val;
        CharTreeNode left;
        CharTreeNode right;
        CharTreeNode(char val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    // char tree serialize
    public String serialize(CharTreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder code = new StringBuilder();
        buildChar(root, code);
        return code.toString();
    }

    // BFS level order
//    public String serialize(TreeNode root) {
//        if(root == null) {
//            return "";
//        }
//        StringBuilder code = new StringBuilder();
//        buildBFS(root, code);
//        // return result, excluding the tail ','
//        return code.substring(0, code.length() - 1);
//    }

    // pre order serialize
//    public String serialize(TreeNode root) {
//        if(root == null) {
//            return "";
//        }
//        StringBuilder code = new StringBuilder();
//        buildPre(root, code);
//        // return result, excluding the tail ','
//        return code.substring(0, code.length() - 1);
//    }

    // post order serialize
//    public String serialize(TreeNode root) {
//        if(root == null) {
//            return "";
//        }
//        StringBuilder code = new StringBuilder();
//        buildPost(root, code);
//        // return result, excluding the tail ','
//        return code.substring(0, code.length() - 1);
//    }


    // Decodes your encoded data to tree.
    // deserialize char tree
    public CharTreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        char[] cs = data.toCharArray();
        return extractChar(cs, new int[]{0});
    }

    // BFS level order
//    public TreeNode deserialize(String data) {
//        if(data.length() == 0) {
//            return null;
//        }
//        String[] strs = data.split(",");
//        return extractBFS(strs);
//    }

    // pre order deserialize
//    public TreeNode deserialize(String data) {
//        if(data.length() == 0) {
//            return null;
//        }
//        String[] strs = data.split(",");
//        return extractPre(strs, new int[1]);
//    }

    // post order deserialize
//    public TreeNode deserialize(String data) {
//        if(data.length() == 0) {
//            return null;
//        }
//        String[] strs = data.split(",");
//        int[] idx = new int[]{strs.length - 1};
//        return extractPost(strs, idx);
//    }

    private void buildPre(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append(',');
            return;
        }
        str.append(root.val).append(',');
        buildPre(root.left, str);
        buildPre(root.right, str);
    }

    private TreeNode extractPre(String[] code, int[] idx) {
        if(idx[0] == code.length) {
            return null;
        }
        if(code[idx[0]].length() == 0) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(code[idx[0]++]));
        root.left = extractPre(code, idx);
        root.right = extractPre(code, idx);
        return root;
    }

    private void buildPost(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append(',');
            return;
        }
        buildPost(root.left, str);
        buildPost(root.right, str);
        str.append(root.val).append(',');
    }

    private TreeNode extractPost(String[] code, int[] idx) {
        if(idx[0] == 0) {
            return null;
        }
        if(code[idx[0]].length() == 0) {
            idx[0]--;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(code[idx[0]--]));
        root.right = extractPost(code, idx);
        root.left = extractPost(code, idx);
        return root;
    }

    private void buildBFS(TreeNode root, StringBuilder str) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    str.append("#,");
                } else {
                    str.append(curr.val).append(',');
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
        }
    }

    private TreeNode extractBFS(String[] code) {
        TreeNode root = new TreeNode(Integer.parseInt(code[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                if(!code[++idx].equals("#")) {
                    curr.left = new TreeNode(Integer.parseInt(code[idx]));
                    queue.offer(curr.left);
                }
                if(!code[++idx].equals("#")) {
                    curr.right = new TreeNode(Integer.parseInt(code[idx]));
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    private void buildChar(CharTreeNode root, StringBuilder str) {
        if(root == null) {
            str.append('#');
            return;
        }
        str.append(root.val);
        buildChar(root.left, str);
        buildChar(root.right, str);
    }

    private CharTreeNode extractChar(char[] code, int[] idx) {
        if(code[idx[0]] == '#') {
            idx[0]++;
            return null;
        }
        CharTreeNode root = new CharTreeNode(code[idx[0]++]);
        root.left = extractChar(code, idx);
        root.right = extractChar(code, idx);
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree test = new SerializeDeserializeBinaryTree();
        CharTreeNode root = test.new CharTreeNode('1');
        root.left = test.new CharTreeNode('2');
        root.right = test.new CharTreeNode('3');
        root.right.left = test.new CharTreeNode('4');
        System.out.println(test.serialize(test.deserialize(test.serialize(root))));
    }
}
