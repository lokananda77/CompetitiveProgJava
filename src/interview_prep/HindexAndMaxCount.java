package interview_prep;

import java.util.Arrays;

public class HindexAndMaxCount {
	public static int hIndex(int[] citations) {
	    int n = citations.length, tot=0;
	    int[] arr = new int[n+1];	//by default filled with 0
	    for (int i=0; i<n; i++) {
	        if (citations[i]>=n) arr[n]++;
	        else arr[citations[i]]++;
	    }
	    for (int i=n; i>=0; i--) {
	        tot += arr[i];
	        if (tot>=i) return i;
	    }
	    return 0;
	}
	
	public static int myhIndex(int[] citations) {
        int [] citationsadd = new int[citations.length+1];
        citationsadd[0] = 0;
        for (int h=0;h<citations.length;h++) {
            citationsadd[h+1] = citations[h];
        }
        Arrays.sort(citationsadd);
        int decCit;
        int hIndex = 0;
        int l = citationsadd.length;
        if (l > 1) {
            for (int k=1;k<citationsadd.length;k++) {
                decCit = citationsadd[k];
                while (decCit > citationsadd[k-1]) {
                    if (decCit <= l - k ) {
                        hIndex = Math.max(hIndex, decCit);
                    }
                    decCit--;
                }
            }
        }
        return hIndex;
    }
	
	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{0,1,3,5,6,8,9,10}));
		System.out.println(myhIndex(new int[]{0,1,3,5,6,8,9,10}));
	}
}
