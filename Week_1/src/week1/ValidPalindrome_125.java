package week1;

public class ValidPalindrome_125 {
	public boolean isPalindrome(String s) {
        if(s.isEmpty())return true;
        char[] str=s.toCharArray();
        int start=0,end=str.length-1;
        while(start<end){
        	while(start<str.length&&!Character.isLetterOrDigit(str[start]))start++;
        	while(end>=0&&!Character.isLetterOrDigit(str[end]))end--;
        	if(start>=end)return true;
        	if(Character.toLowerCase(str[start])!=Character.toLowerCase(str[end]))return false;
        	else {
        		start++;
        		end--;
        	}
        }
        return true;
    }
}
