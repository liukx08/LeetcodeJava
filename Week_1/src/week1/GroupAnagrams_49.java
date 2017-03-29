package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
	public List<List<String>> groupAnagram(String[] strs) {
		List<List<String>> res=new ArrayList<List<String>>();
        if(strs.length==0)return res;
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String str:strs){
        	char[] word=str.toCharArray();
        	Arrays.sort(word);
        	String tmp=String.valueOf(word);		//  word.toString() is wrong!!
        	if(!map.containsKey(tmp)) map.put(tmp, new ArrayList<String>());
        	map.get(tmp).add(str);
        }
        return new ArrayList<List<String>>(map.values());
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {	// exceeds time limit, it is too slow to compare one by one, should use hashmap
        List<List<String>> res=new ArrayList<List<String>>();
        if(strs.length==0)return res;
        List<String> grp=new ArrayList<String>();
        grp.add(strs[0]);
        res.add(grp);
        boolean flag=false;
        for(int i=1;i<strs.length;i++){
        	for(int j=0;j<res.size();j++){
        		if(isAnagrams(strs[i],res.get(j).get(0))){
        			flag=res.get(j).add(strs[i]);
        		}
        	}
        	if(!flag){
        	    grp=new ArrayList<String>();
        	    grp.add(strs[i]);
        	    res.add(grp);
        	}
        	flag=false;
        }
        return res;
    }
    
    private boolean isAnagrams(String word1,String word2){
    	char[] w1=word1.toCharArray();
    	char[] w2=word2.toCharArray();
    	if(w1.length!=w2.length)return false;
    	else {
    	    int[] alphabetic=new int[26];
    	    for(int i=0;i<w1.length;i++){
    	    	alphabetic[w1[i]-'a']++;
    	    	alphabetic[w2[i]-'a']--;
    	    }
    	    for(int i=0;i<26;i++){
    	    	if(alphabetic[i]!=0)return false;
    	    }
    	    return true;
    	}
    }
}
