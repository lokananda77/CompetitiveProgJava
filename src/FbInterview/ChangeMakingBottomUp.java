package FbInterview;

import java.util.Arrays;

public class ChangeMakingBottomUp {
	public static int combinationSum4(int[] nums, int target) {
        int[][]m = new int[nums.length + 1][target+1];
        
        // if amount=0 then just return empty set to make the change
		for (int i = 0; i <= nums.length; i++) {
			m[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= target; i++) {
			m[0][i] = 0;
		}
		
		
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				// check if the coin value is less than the amount needed
				if (nums[i - 1] <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					m[i][j] = m[i - 1][j] + m[i][j - nums[i - 1]];
				} else {
					// just copy the value from the top
					m[i][j] = m[i - 1][j];
				}
			}
		}
		for(int k=0; k<target; k++)
		    System.out.println(Arrays.toString(m[k]));
		return m[nums.length][target];
    }
	
	public static void main(String[] args) {
		System.out.println(combinationSum4(new int[]{1,2,3}, 4));
	}
}
