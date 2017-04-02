package week2homework;

public class DeleteNodeInBST_450 {					// use divide and conquer and recursion
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;				// base case
        if(root.left==null&&root.right==null)return root.val==key?null:root; // case 1: no subtree
        if(root.left==null){	// case 2: only has right subtree
        	if(root.val==key)return root.right;		// process current level
        	root.right=deleteNode(root.right,key);	// recursion
        	return root;
        }
        if(root.right==null){	// case 3: only has left subtree
        	if(root.val==key)return root.left;	// process current level
        	root.left=deleteNode(root.left,key);	// recursion
        	return root;
        }						// case 4: has both left and right subtree
        if(root.val>key){					// target in left subtree
        	root.left=deleteNode(root.left,key);	// recursion
        } else if(root.val<key){			// target in right subtree
        	root.right=deleteNode(root.right,key);	// recursion
        } else {							// target is root
        	TreeNode parent=root,curr=root.right;	// search successor of root in right subtree, also get its parent
        	while(curr.left!=null){			// the successor of root is the leftmost node in the right subtree
        		parent=curr;
        		curr=curr.left;
        	}
        	if(parent==root){		// the successor is root.right (right subtree has no left subtree)
        		curr.left=root.left;
        		root=curr;
        	} else {				// found successor, move successor to new root
        		parent.left=curr.right;
        		curr.left=root.left;
        		curr.right=root.right;
        		root=curr;
        	}
        }
        return root;
    }
}
