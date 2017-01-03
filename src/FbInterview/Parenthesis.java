package FbInterview;

public class Parenthesis {
    static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            brackets(openStock-1, closeStock+1, s + "<");
        }
        if (closeStock > 0) {
            brackets(openStock, closeStock-1, s + ">");
        }
    }
    
    static String open  = "([<{";
    static String close = ")]>}";

    static boolean isOpen(char ch) {
        return open.indexOf(ch) != -1;
    }
    static boolean isClose(char ch) {
        return close.indexOf(ch) != -1;
    }
    static boolean isMatching(char chOpen, char chClose) {
        return open.indexOf(chOpen) == close.indexOf(chClose);
    }

    static boolean isBalanced(String input, String stack) {
        return
            input.isEmpty() ?
                stack.isEmpty()
            : isOpen(input.charAt(0)) ?
                isBalanced(input.substring(1), input.charAt(0) + stack)
            : isClose(input.charAt(0)) ?
                !stack.isEmpty() && isMatching(stack.charAt(0), input.charAt(0))
                  && isBalanced(input.substring(1), stack.substring(1))
            : isBalanced(input.substring(1), stack);
    }
    
    public static void main(String[] args) {
        brackets(3, 0, "");
    }
}