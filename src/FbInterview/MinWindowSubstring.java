package FbInterview;

import java.util.HashMap;

public class MinWindowSubstring {

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	    char[] t1 = t.toCharArray();
		for(char c: t1) {
			if (hm.get(c) != null)
				hm.put(c, (hm.get(c))+1);
			else
				hm.put(c, 1);
		}
	    
		System.out.println(hm);
	    int counter=t.length(), begin=0, end=0, d=100000, head=0;
	    
	    while(end<s.length() - 1){
	    	System.out.println(end);
	    	if (hm.get(s.charAt(end++)) != null) {
	    		if(hm.get(s.charAt(end++)) - 1 > 0) counter--; //in t
	    	}
	    
	        while(counter==0){ //valid
	        	if(end-begin<d)  d=end-(head=begin);
	            if(hm.get(s.charAt(begin++))==0) counter++;  //make it invalid
	        
	        }  
	    }
	    
	    return d==100000? "":s.substring(head, d);
	}
	
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		System.out.println(minWindow(s, "ABC"));
	}
}
