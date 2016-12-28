package interview_prep;

import java.util.Random;

public class Ctci17d11 {
	    int[] nums;
	    Random rand;
	    public Ctci17d11(int[] nums) {
	        this.nums = nums;
	        this.rand = new Random();
	    }
	    public int pick(int target) {
	        int total = 0;
	        int res = -1;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == target) {
	                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
	                int x = rand.nextInt(++total); 
	                res = x == 0 ? i : res;
	            }
	        }
	        return res;
	    }
	    
	    public static void main(String[] args) {
	    	int[] nums = new int[] {1,2,3,3,3};
	    	int count2 = 0;
	    	int count3 = 0;
	    	int count4 = 0;
	    	Ctci17d11 solution = new Ctci17d11(nums);
	    	for (int i = 0; i < 1000; i++) {
				if (2 == solution.pick(3)) {
					count2++;
				}
				if (3 == solution.pick(3)) {
					count3++;
				}
				if (4 == solution.pick(3)) {
					count4++;
				}

			}
	    	System.out.println(count2);
	    	System.out.println(count3);
	    	System.out.println(count4);
		}
	}

