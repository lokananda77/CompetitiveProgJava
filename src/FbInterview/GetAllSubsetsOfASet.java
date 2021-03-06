package FbInterview;

import java.util.*;

public class GetAllSubsetsOfASet {

	
	public static int fact(int n, int level)
    {
       int result=0;
       if(n==0 || n==1)
         return 1;
       // level helps u pass the state
       System.out.println(level + " before");
       System.out.println("						result before" + n);
       System.out.println("Aresult=" + result);
       result = fact(n-1, level + 1) * n;
       System.out.println("Bresult=" + result);
       System.out.println("						result after" + n);
       System.out.println(level + " after");
       return result;
    }
	
	/* using recursion to generate something */
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
	    Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> each = new ArrayList<>();
	    boolean[] ifPrint = new boolean[nums.length];
	    helper(res, each, 0, nums);
	    return res;
	}
	public static void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
	    int level = 0;
		if (pos <= n.length) {
	    	//System.out.println("subset");
	    	System.out.println(each + " pos " + pos + " level " + level);
	        res.add(each);
	    } else {
	    	System.out.println("2Not Base Case");
	    }
	    int i = pos;
	    
	    while (i < n.length) {
	    	//generate all possible combinations of including an element in n[i]
	        each.add(n[i]);
	        helper(res, new ArrayList<>(each), i + 1, n);
	        each.remove(each.size() - 1);
	        i++;
	        while (i < n.length && n[i] == n[i - 1]) {i++;}
	    }
	    // this line is the base case
	    return;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set when u reach the index equal to the size of the parent set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); 
		} else {
			//System.out.println(index);
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				//System.out.println(subset);
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
			//System.out.println(allsubsets);
		}
		return allsubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	
	public static List<List<Integer>> subsetsWithDup2(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0; i<=nums.length;i++)//subset length could vary from 0 to nums.length
		{
			boolean[] ifPrint = new boolean[nums.length];
			helper2(res, ifPrint, 0, i, nums);//start from 0th index, and the size varies for the loop
		}
		return res;
	}
	public static void helper2(List<List<Integer>> res, boolean[] ifPrint, int pos, int remain, int[] nums) {
		if(remain==0)
		{
			List<Integer> x = new ArrayList<Integer>();
			//System.out.print("{");
			//check each ifPrint status to decide print or not
			//System.out.println("subset");
			for(int i=0; i<ifPrint.length;i++)
			{
				if(ifPrint[i]) {
					//System.out.print(nums[i]+",");
					x.add(nums[i]);
				}
			}
			System.out.println(x);
			res.add(x);
		} else {
			//System.out.println("1Not Base Case");
		}
		if (pos+remain<=nums.length)
		{
			int i=pos;
			while(i<nums.length)
			{
				if(!ifPrint[i])
				{
					ifPrint[i] = true;
					helper2(res, ifPrint, i+1, remain-1, nums);
					ifPrint[i] = false;
				}
				i++;
			}
		}
		//System.out.println("returned");
		return;

	}
	
	public static List<List<Integer>> subsetsWithDup3(int[] candidates, int target) {
	    Arrays.sort(candidates);
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> each = new ArrayList<>();
	    helper3(res, each, 0, candidates, target, 0);
	    return res;
	}
	public static void helper3(List<List<Integer>> res, List<Integer> each, int pos, int[] n, int target, int level) {
	    int i = pos;
	    if (i == n.length) {
	    	System.out.println(each + "level " + level);
	        return;
	    } else if (i < n.length) {
	    	System.out.println(each + "level " + level);
	            res.add(each);
    	    while (i < n.length) {
    	    	//generate all possible combinations of including an element in n[i]

    	        each.add(n[i]);
    	        helper3(res, new ArrayList<>(each), i + 1, n, target, level + 1);
    	        each.remove(each.size() - 1);
    	        
    	        i++;
    	        while (i < n.length && n[i] == n[i - 1]) {i++;}
    	    }
	    }
	}
	
	static void RecSubsets(String soFar, String rest)
	{
	 if (rest.isEmpty())
		 System.out.println(soFar);
	 else {
		 RecSubsets(soFar + rest.charAt(0), rest.substring(1)); // include first char
		 
		 RecSubsets(soFar, rest.substring(1)); // exclude first char
	 }
	}
	public static void main(String[] args) {
		
		fact(5, 0);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 5; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		
		for(List<Integer>y:subsets) {
			System.out.println(y);
		}
		System.out.println(" ");
		List<List<Integer>> x = subsetsWithDup(new int[]{1,2,3,4});
		for(List<Integer>y:x) {
			//System.out.println(y);
		}
		System.out.println(" ");
		List<List<Integer>> z = subsetsWithDup2(new int[]{1,2,3,4});
		for(List<Integer>y:z) {
			//System.out.println(y);
		}
		System.out.println("");
		List<List<Integer>> zz = subsetsWithDup3(new int[]{1,2,3,4}, 5);
		
		RecSubsets("", "ABCDE");
//		ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
//		System.out.println(subsets2.toString());		
	}

}
