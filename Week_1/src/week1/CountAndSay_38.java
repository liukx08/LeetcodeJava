package week1;

public class CountAndSay_38 {
	public String countAndSay(int n) {
        StringBuilder curr=new StringBuilder(),prev;
        if(n==0)return curr.toString();
        curr.append(1);
        int count=1;
        char digit=curr.charAt(0);
        for(int i=0;i<n-1;i++){
        	prev=curr;
        	curr=new StringBuilder();
        	count=1;
        	digit=prev.charAt(0);
        	for(int j=1,length=prev.length();j<length;j++){
        		if(digit==prev.charAt(j))count++;
        		else{
        			curr.append(count).append(digit);
        			digit=prev.charAt(j);
        			count=1;
        		}
        	}
        	curr.append(count).append(digit);
        }
        return curr.toString();
    }
}
