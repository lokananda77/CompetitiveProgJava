package interview_prep;

import java.util.LinkedList;
import java.util.List;

public class EncodeandDecodeStrings {
	 
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<String>();
        if (null == s || s.length() == 0) {
            return res;
        }
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (s.charAt(end) == '#') {
                int length = Integer.valueOf(s.substring(start, end));
                res.add(s.substring(end + 1, end + 1 + length));
                start = end + 1 + length;
                end = start;
            }
            end++;
        }
        return res;
    }
 
    public static void main(String[] args) {
        EncodeandDecodeStrings encodeandDecodeStrings = new EncodeandDecodeStrings();
        List<String> list = new LinkedList<String>();
        // ["63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "]
        list.add("63/Rc");
        list.add("h");
        list.add("BmI3FS~J9#vmk");
        list.add("7uBZ?7*/");
        list.add("24h+X");
        list.add("0 ");
        String s = encodeandDecodeStrings.encode(list);
        System.out.println(s);
        System.out.println(encodeandDecodeStrings.decode(s));
    }
}
