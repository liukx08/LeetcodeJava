package week1;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder pre=new StringBuilder();
        int size=strs.length;
        if(size==0)return pre.toString();
        if(size==1)return strs[0];
        int length=strs[0].length();
        char curr;
        for(int i=0;i<length;i++){
        	curr=strs[0].charAt(i);
        	for(int j=1;j<size;j++){
        		if(i>=strs[j].length()||strs[j].charAt(i)!=curr)return pre.toString();
        	}
        	pre.append(curr);
        }
        return pre.toString();
    }
}
