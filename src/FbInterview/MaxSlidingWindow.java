//{2, 3, 4, 2, 6, 2, 5, 1}
//{4, 4, 6, 6, 6, 5}

package FbInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow {


	public static void maxSldWindow (int nums[], int size) {
		int k = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		q.add(nums[k]);
		k = 1;
		//Integer d = new Integer(3);
		while(k < nums.length) {
			if (nums[k] < q.peek()) {
				q.add(nums[k]);
				if (k >= size -1) {
					System.out.println(q);
					System.out.println("1st");
					ans.add(q.peek());
				}
			} else {
				while(!q.isEmpty())
					q.remove();
				q.add(nums[k]);
				if (k >= size - 1) {
					System.out.println(q);
					System.out.println("2nd");
					ans.add(q.peek());
				}
			}
			k++;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int[] nums = {2, 3, 4, 2, 6, 2, 5, 1}; 
		maxSldWindow(nums, 3);
	}
}
