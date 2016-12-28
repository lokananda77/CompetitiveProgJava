package FbInterview;

import java.util.List;

public class AllPermutations {
	
	public static String swap(int i, int j, char[] str) {
		//System.out.println(str);
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		return new String(str);
	}
	public static void printperm(int l, int r, String str) {
		//ABC
		//BCA CBA ACB CAB
		
		//((()))
		if (l==r) {
			System.out.println(str);
		}
		for(int i=l;i<r;i++) {
			str = swap(l, i, str.toCharArray());
			printperm(l+1, r, str);
			str = swap(l, i, str.toCharArray());
		}
	}
	
	static void RecPermute(String soFar, String rest)
	{
		if (rest.equals("")) {
			System.out.println(soFar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String remaining = rest.substring(0, i)
						+ rest.substring(i+1);
				RecPermute(soFar + rest.charAt(i), remaining);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		printperm(0, n-1, str);
		//RecPermute("", str);
	}
}
