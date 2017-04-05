package leetcode;

public class ConstructBTFromString_536 {
    public TreeNode str2tree(String s) {
    	if(s.length()==0)return null;
    	char[] str=s.toCharArray();
    	return str2tree(str,0,str.length);
    }
    
    private TreeNode str2tree(char[] s,int start,int end){
    	int i,j=start;
    	while(j<end&&(s[j]=='-'||Character.isDigit(s[j])))j++;
    	TreeNode root=new TreeNode(Integer.parseInt(new String(s,start,j-start)));
    	if(j==end)return root;
    	i=++j;
    	int count=1;
    	while(count!=0){
    		if(s[j]=='(')count++;
    		if(s[j]==')')count--;
    		j++;
    	}
    	root.left=str2tree(s,i,j-1);
    	if(j<end)root.right=str2tree(s,j+1,end-1);
    	return root;
    }
}
