
package interview_prep;

import java.util.Arrays;

public class MergeAndCount {

//	public static void merge(int[] a,int left[],int right[]) {
//		int i = 0, j = 0, k=0;
//		//System.out.println(Arrays.toString(left));
//		//System.out.println(Arrays.toString(right));
//		while (j!= left.length && k!=right.length) {
//			if (left[j] < right[k]) {
//				a[i] = left[j];
//				j++;
//			} else if (left[j] > right[k]) {
//				a[i] = right[k];
//				k++;
//			}
//			i++;
//		}
//		if (j == left.length) {
//			for (int t1=k; t1<right.length; t1++, i++) {
//				a[i] = left[t1];
//			}
//		}
//		if (k == right.length) {
//			for (int t2=j; t2 <left.length; t2++, i++) {
//				a[i] = right[t2];
//			}
//		}
//	}
	
	public static int merge(int[] result, int[] a, int[] b) {
		int i, j, k;
		int inv_count = 0;
		i = j = k = 0;
		int mid = result.length/2;
		while (i < a.length || j < b.length) {
			if (i < a.length && j < b.length) { // Both array have elements
				if (a[i] < b[j])
					result[k++] = a[i++];
				else {
					result[k++] = b[j++];
					inv_count = inv_count + (mid - i);
				}
			} else if (i == a.length)
				result[k++] = b[j++]; // a is empty
			else if (j == b.length)
				result[k++] = a[i++]; // b is empty
		}
		return inv_count;
	}
	
//	public static int mergeandcount(int[] a, int l) {
//		int n = l;
//		int mid = n/2;
//		//System.out.println(mid);
//		int left[] = new int[n/2];
//		int right[] = new int[n/2];
//		for (int i=0; i < mid; i++) {
//			left[i] = a[i]; 
//		}
//		for (int i=mid, j=0; i < n; i++,j++) {
//			right[j] = a[i]; 
//		}
//		if (n >=1) {
//			mergeandcount(left, n/2);
//			mergeandcount(right, n/2);
//			merge(a, left, right);
//		}
//		return 1;
//	}
	
	public static int mergeandcount(int[] a) {
		int middle = a.length/2;
		int inv_count = 0;
		if (a.length == 1 ) {
			return 0;
		}
		//System.out.println(mid);
		int left[] = new int[middle];
		int right[] = new int[a.length-middle];
		for (int i=0; i < middle; i++) {
			left[i] = a[i]; 
		}
//		for (int i=middle, j=0; i < a.length; i++,j++) {
//			right[j] = a[i]; 
//		}
		for ( int i = 0; i < a.length-middle; i++ )
	         right[i] = a[i+middle];
		// this shud be same as left < right
		inv_count = mergeandcount(left);
		inv_count += mergeandcount(right);
		inv_count += merge(a, left, right);
		return inv_count;
	}
	
	public static void main(String args[]) {
		int[] a = {3, 5, 4, 6, 7 , 8 , 11, 10};
		//System.out.println(Arrays.toString(a));
		System.out.println(mergeandcount(a));
		for (int k=0; k< a.length; k++) { 
			System.out.print(a[k] + " ");
		}
	}
}
