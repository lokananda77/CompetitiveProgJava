// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, Tree T) {
        Integer size = new Integer(0);
        isRootInRange(A, B, T, size);
        return size;
        // if (isRootInRange(A, B, T, size)) {
        //     return size;
        // } else {
        //     return 0;
        // }
    }
    
    public boolean isRootInRange(int A, int B, Tree T, Integer size) {
        Integer leftSize = new Integer(0);
        Integer rightSize = new Integer(0);
        if (T != null) {
            boolean leftIsInRange = isRootInRange(A, B, T.l, leftSize);
            boolean rightIsInRange = isRootInRange(A, B, T.r, rightSize);
            
            if (T.x >=A && T.x <= B && leftIsInRange && rightIsInRange) {
                size = leftSize + rightSize + new Integer(1);
                System.out.println(T.x + " 1 t " + size + " " + rightSize + " " + leftSize);
                return true;
            } else if (T.x >=A && T.x <= B && leftIsInRange && !rightIsInRange) {
                size = leftSize;
                System.out.println(T.x + " 2 f " + size);
                return false;
            } else if (T.x >=A && T.x <= B && !leftIsInRange && rightIsInRange) {
                size = rightSize;
                System.out.println(T.x + " 3 f " + size);
                return false;
            } else if (T.x >=A && T.x <= B && !leftIsInRange && !rightIsInRange) {
                size = new Integer(0);
                System.out.println(T.x + " 4 f " + size);
                return false;
            } else if (T.x < A && T.x > B) {
                size = Math.max(leftSize, rightSize);
                System.out.println(T.x + " 5 f " + size);
                return false;
            }
        } else {
            size = new Integer(0);
            System.out.println(T + " 6 t " + size);
            return true;
        }
        return false;
    }
}