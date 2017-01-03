package interview_prep;

public class IsReducible {
	static boolean is_reducible(String s) {
	    int i = 0;
	    int l = s.length();
	    while (i < l-1) {
	        if (s.charAt(i) == s.charAt(i+1)) {
	            return true;
	        }
	        i++;
	    }
	    return false;
	}

	public static void main(String[] args) {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	    String s1;
	    String s2;
	    String s = "aa";
	    int i = 0;
	    while (is_reducible(s)) {
	    	System.out.println(s);
		    System.out.println("printed");
	    	int l = s.length();
	        i = 0;
	        while (i < l && s.charAt(i) != s.charAt(i+1)) {
	            i++;
	        }
	        if(i!=l) {
	            s1 = s.substring(0,i);
	            if (s.length()>2)
	            	s2 = s.substring(i+2,l);
	            else
	            	s2= "";
	            s = s1.concat(s2);
	            System.out.println(s);
	        }
	    }
	    System.out.println(s);
	}
}


