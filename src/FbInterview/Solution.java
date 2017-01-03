package FbInterview;

public class Solution {
    public static String countAndSay(int n) {
        String ans = "1";
        if (n==1) {
            return ans;
        } else {
            while(n-->1) {
                ans = genNext(Integer.parseInt(ans,10));
            }
        }
        return ans;
    }
    public static String genNext(int n) {
        int l = String.valueOf(n).length();
        int curdigit;
        int k = (int)Math.pow(10,l-1);
        int prevdigit = n/k;
        int ct=0;
        StringBuilder sb= new StringBuilder("");
        do {
            k = (int)Math.pow(10,--l);
            curdigit = n/k;
            if (prevdigit!=curdigit)
             {
                 sb = genPartialString(sb, prevdigit, ct);
                 ct = 1;
             } else {
                 ct++;
             }
            prevdigit = curdigit;
            n = n%k;
        } while(l >0 );
        
        sb = genPartialString(sb, prevdigit, ct);
        return sb.toString();
    }
    
    static StringBuilder genPartialString(StringBuilder sb, int j, int ct) {
        return sb.append(String.valueOf(ct)).append(String.valueOf(j));
    }
    
    public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(10));
	}
}