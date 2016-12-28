package FbInterview;

import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode398 {
        HashMap<Integer, ArrayList<Integer>> map;
    public Leetcode398(int[] nums) {
        map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            
            {
                map.put(nums[i],new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
//    public int pick(int target) {
//        int count=map.get(target).size();
//        //generate a random integer from 0 to count-1.
//        int index=0+(int)(Math.random()*(count-1-0+1));
//        return map.get(target).get(index);
//        
//    }
    
    public int pick(int target) {
        List<Integer> indList = hm.get(target);
        Random rnd = new Random();
        int indindex = rnd.nextInt(indList.size());
        return indList.get(indindex);
    }
}

