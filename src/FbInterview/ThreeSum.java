package FbInterview;
import java.util.*;

class ThreeSum {
public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
 
    if(nums == null || nums.length<3)
        return result;
 
    Arrays.sort(nums);
 
    for(int i=0; i<nums.length-2; i++){
        if(i==0 || nums[i] > nums[i-1]){
            int j=i+1;
            int k=nums.length-1;
 
            while(j<k) {
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
 
                    j++;
                    k--;
 
                    //handle duplicate here
                    while(j<k && nums[j]==nums[j-1])
                    	j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--;
 
                } else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                } else{
                    k--;
                }
            }
        }
 
    }
 
    return result;
}

public static List<List<Integer>> threeSum1(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<List<Integer>>();
    for (int i=0;i<nums.length;i++) {
        
        int j = i + 1;
        int k = nums.length -1;
        while(j < k) {
        	Integer[] temp = new Integer[3];
            if (nums[i] + nums[j] + nums[k] == 0) {
                temp[0] = nums[i];
                temp[1] = nums[j];
                temp[2] = nums[k];
                //System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                triplets.add(Arrays.asList(temp));
                if (nums[k-1] == nums[k]) {
                    k = k -2;
                }
                k--;
                if (nums[j] == nums[j+1]) {
                    j = j + 2;
                }
                j++;
            } else if (nums[i] + nums[j] + nums[k] > 0) {
                k--;
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            }
        }
    }
    return triplets;
}
public static void main(String[] args) {
	int [] arr = {8, 2, 3,1, 0, -1, -2};
	System.out.println(threeSum(arr));
	System.out.println(threeSum1(arr));
}

}