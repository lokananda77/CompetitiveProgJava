package interview_prep;

import java.util.Hashtable;

public class FirstNonDuplicate {
	public static char firstnonduplicate(String ip) {
	    Hashtable<Character, Character> ht = new Hashtable<Character, Character>();
	    for(int k =0; k< ip.length(); k++) {
	        if(ht.containsKey(ip.charAt(k))== false) {
	            ht.put(ip.charAt(k), 'f');
	        } else if ((Character)ht.get(ip.charAt(k)) == 'f') {
	            ht.put(ip.charAt(k), 'd');
	        } 
	     }
	           
	    System.out.println(ht);
	    for (int j=0; j<ip.length(); j++) {
	        if ((char) ht.get(ip.charAt(j)) == 'f') {
	            return ip.charAt(j);
	        }
	    }
	    return (Character) null;
	}

	public static void main(String args[]) {
		System.out.println(firstnonduplicate("teeth"));
	}
}

