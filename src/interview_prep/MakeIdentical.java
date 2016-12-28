package interview_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author lokananda
 *
 *	Minimum swaps to make two arrays identical
//	Given two arrays which have same values but in different order, 
//	we need to make second array same as first array using minimum 
//	number of swaps.
 * Input  : arrA[] = {3, 6, 4, 8}, 
         arrB[] = {4, 6, 8, 3}
Output : 2
we can make arrB to same as arrA in 2 swaps 
which are shown below,
swap 4 with 8,   arrB = {8, 6, 4, 3}
swap 8 with 3,   arrB = {3, 6, 4, 8}
 */

public class MakeIdentical {
	
	public static int[] swap(int A[], int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
		//System.out.println("swapped");
		//System.out.println(Arrays.toString(A));
		return A;
	}

	
	public static int minSwaps(int A[], int B[]) {
		Queue<int[]> q= new LinkedList<int[]>();
		List<int[]> closed= new ArrayList<int[]>();

		int steps = 0;
		
		Queue<int[]> cq;
		
		for (int k = 0; k < B.length; k++) {
			for (int i = 0; i < B.length; i++) {
				if (i != k) {
					int[] X = swap(Arrays.copyOf(B, B.length), k,i);
					if (!closed.contains(X));
						q.add(X);
				}
			}
		}
		
		while (!q.isEmpty()) {
			for(int[] s : q) { 
				  System.out.print(Arrays.toString(s)); 
			}
			System.out.println("________________");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cq = new LinkedList<int[]>(q);
			while(!q.isEmpty()) {
				q.poll();
			}
			while (!cq.isEmpty()) {
				//System.out.println(cq.size());
				int[] check = cq.poll();
				if (Arrays.equals(check, A)) {
					return steps;
				}
				closed.add(check);
				for (int k = 0; k < check.length; k++) {
					for (int i = 0; i < check.length; i++) {
						if (i != k) {
							int[] X = swap(Arrays.copyOf(check, check.length), k,i);
							System.out.println("");
							System.out.println("CLOSED:");
							for(int[] s : closed) { 
								  System.out.print(Arrays.toString(s)); 
							}
							if (!closed.contains(X))
								{
									q.add(X);
									System.out.println("Q size:" + q.size());
								} else {
									System.out.println(Arrays.toString(X) + " already exists");
								}
								
						}
					}
				}
			}
			steps = steps + 1;
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(minSwaps(new int[]{3, 6, 4, 8}, new int[]{4, 6, 8, 3}));
	}
}
