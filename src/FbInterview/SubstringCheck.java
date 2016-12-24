package FbInterview;

public class SubstringCheck {
    public static boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for (int i = l/2; i>=1; i--) {
        	String sb = new String("");
            if (l%i == 0) {
                int k = l/i;
                System.out.println(k);
                for (int j=1;j<=k;j++) {
                    sb = sb + str.substring(0,i);
                    System.out.println(sb);
                }
                if (str.equals(sb)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean madeofdict(String str, String[] dict, int dictword) {
    	int [][] madeofdict = new int[100][100];
    	boolean ans = false;
    	if ( str.length() > 0) {
    		int dictOccPos = str.indexOf(dict[dictword]);
        	System.out.println(str);
    		System.out.println(dictword);
    		boolean ans1 = (madeofdict[0][dictOccPos] != -1) ? madeofdict(str.substring(0, dictOccPos), dict,dictword + 1): madeofdict[0][dictOccPos] ==1;
    		boolean ans2 = (madeofdict[0][dictOccPos] != -1) ? madeofdict(str.substring(dictOccPos, dict[dictword].length()), dict,dictword + 1): madeofdict[dictOccPos][dict[dictword].length()] ==1;
    				madeofdict( str.substring(dictOccPos, dict[dictword].length()), dict, dictword +1);
    		return ans1 && ans2;
    	} else {
    		return true;
    	}
    }
    
    public static void main(String[] args) {
    	String [] dict = {"ja", "shree", "i"};
    	System.out.println(madeofdict("jaishree", dict, 0));
    	//System.out.println(repeatedSubstringPattern(""));
	}
}