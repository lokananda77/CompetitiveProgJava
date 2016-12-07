package interview_prep;

public class ValidAnagram {
    final static int LETTERS_LEN = 256;	
    public static boolean isAnagram(String s, String t) {
        int[] count1 = new int[LETTERS_LEN];
        int[] count2 = new int[LETTERS_LEN];
        if (s.length() == t.length()) {
            for (int k=0; k<s.length(); k++) {
                count1[s.charAt(k)]++;
                count2[t.charAt(k)]++;
            }
            for (int k=0; k<s.length(); k++) {
                if (count1[s.charAt(k)] != count2[t.charAt(k)]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String args[]) {
		System.out.println(isAnagram("teeth", "dss"));
	}
}
