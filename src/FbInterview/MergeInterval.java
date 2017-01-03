package FbInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeInterval {
    
    public static boolean contains(Interval o1, int value)
    {
        if (value >= o1.start && value <= o1.end)
        {
            return true;
        }
        return false;
    }
 
    public static boolean overlaps(Interval o1, Interval o2)
    {
        if (contains(o1, o2.start) || contains(o1, o2.end) 
            || contains(o2, o1.start) || contains(o2, o1.end))
        {
            return true;
        }
     
        return false;
    }
 
    public static Interval mergeivl(Interval o1, Interval o2)
    {
        int newstart = (o1.start < o2.start) ? o1.start : o2.start;
        int newend = (o2.end > o1.end) ? o2.end : o2.end;
        return new Interval(newstart, newend);
    }


    public static List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> results = new Stack<Interval>();
        if (intervals != null)
        {
            Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return 1;
                else if (o1.start == o2.start) return 0;
                else return -1;
            }
            });
            System.out.println(intervals);
     
            for(Interval ivl:intervals)
            {
                if (results.size() == 0)
                {
                    results.add(ivl);
                }
                else
                {
                    Interval top = results.peek();
                    if (overlaps(top, ivl))
                    {
                        Interval unionivl = mergeivl(top,ivl);
                        results.pop();
                        results.push(unionivl);
                    }
                    else
                    {
                        results.push(ivl);
                    }
                }
            }
        }
        
        return results;
    }
    
    public static void main(String[] args) {
		Interval i1 = new Interval(2,3);
		Interval i2 = new Interval(4,7);
		Interval i3 = new Interval(6,8);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		List<Interval> m = merge(list);
		for(Interval f:m) {
			System.out.println(f.start + "" + f.end);
		}
	}
}
