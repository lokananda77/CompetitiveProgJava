package FbInterview;

import java.util.HashSet;
import java.util.Set;

public class LongestSubWoRe {
	/*The idea is use a hash set to track the longest substring without 
	 * repeating characters so far, use a fast pointer j to see if character
	 *  j is in the hash set or not, if not, great, add it to the hash set, 
	 *  move j forward and update the max length, otherwise, delete from the
	 *   head by using a slow pointer i until we can put character j to the
	 *    hash set.
	 */


	public static int lengthOfLongestSubstring(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    while (j < s.length()) {
	    	System.out.println(j);
	    	System.out.println(set);
	    	// if set doesnot contain a character in string - add it to set
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j));
	            j++;
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++));
	        }
	    }
	    
	    return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
