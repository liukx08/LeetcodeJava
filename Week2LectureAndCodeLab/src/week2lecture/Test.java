package  week2lecture;

public class Test {
	public static void main(String[] args){
		IterationMethods test=new IterationMethods();
		TreeNode root=null;
		root=test.insertBST(root, 5);
//		root=test.insertBST(root, 3);
//		root=test.insertBST(root, 7);
//		root=test.insertBST(root, 2);
//		root=test.insertBST(root, 4);
//		root=test.insertBST(root, 6);
//		root=test.insertBST(root, 8);
//		root.right.val=1;
		System.out.println(test.isValidBST(root));
	}
}
