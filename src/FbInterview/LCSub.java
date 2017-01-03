package FbInterview;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LCSub {
  public static int LCS(String x,String y,int m, int n) {
    if(m==0 || n==0) {
      return 0;
    } else if(x.charAt(m-1)==y.charAt(n-1)) {
      return 1 + LCS(x,y,m-1,n-1);
    } else {
      return Math.max(LCS(x,y,m,n-1),LCS(x,y,m-1,n));
    }
  }
  
  public static int LCSdup(String x,String y,int m, int n) {
	  	int [][]L = new int[m+1][n+1];
	    for (int i = 0; i <=m; i++) {
			for (int j = 0; j <=n; j++) {
				if(i==0 || j==0) {
					L[i][j] = 0;
				} else if (x.charAt(i-1) == y.charAt(j-1)) {
					L[i][j] = L[i-1][j-1] +1;
				} else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}
	    for(int[]arr:L) {
	    	System.out.println(Arrays.toString(arr));
	    }
	    return L[m][n];
	  }
  
  public static void main(String[] args) {
    //ArrayList<String> strings = new ArrayList<String>();
    // strings.add("Hello, World!");
    // strings.add("Welcome to CoderPad.");
    // strings.add("This pad is running Java 8.");

     System.out.println(LCS("abcdeofi", "acgfeoi", 8,7));
  }
}