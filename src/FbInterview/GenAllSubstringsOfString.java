package FbInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenAllSubstringsOfString {
	static List<String> genSomeRec(String ip) {
		ArrayList<String> x = new ArrayList<String>();
		for (int i = 0; i < ip.length(); i++) {
			for (int k = 1; k < ip.length() - i + 1; k++) {
				x.add(ip.substring(i, i + k));
			}
		}
		//genSomeRec(ip);
		//return new ArrayList<String>(Arrays.asList(""));
		return x;
	}
	static String in = "1234";
	
	
	// got from stack overflow 
	// http://stackoverflow.com/questions/18280442/java-using-recursion-to-create-all-substrings-from-a-string
	// seems complex to understand
	static void substrings(int start, int end){
        if(start == in.length() && end == in.length()){
            return;
        }else{
            if(end == in.length()+1){
                substrings(start+1,start+1);
            }else{
                System.out.println(in.substring(start, end));
                substrings(start, end+1);
            }
        }
    }
	
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		//System.out.println(substring());
		System.out.println(genSomeRec("abcd").size());
		System.out.println(genSomeRec("abcd"));
	}
}
