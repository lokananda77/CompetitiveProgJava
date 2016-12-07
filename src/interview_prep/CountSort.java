package interview_prep;
import java.util.*;

public class CountSort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ip = new int[n];
        int i =0;
        s.nextLine();
        s.nextInt();
        while (i++ < n) {
        	ip[i] = s.nextInt();
        }
        s.close();
    	HashMap<Integer, Integer> count = new HashMap<Integer,Integer>();
        for (int num: ip) {
        	if (count.containsKey(num)) {
        		count.put(num, count.get(num) + 1);
        	} else {
        		count.put(num, 1);
        	}
        }
        System.out.println(count);
    }
}
