package algorithm;

/**
 * You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces,
 * brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses
 * validator.

 Let's say:

 '(', '{', '[' are called "openers."
 ')', '}', ']' are called "closers."
 Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.

 Examples:

 "{ [ ] ( ) }" should return true
 "{ [ ( ] ) }" should return false
 "{ [ }" should return false

 * Created by Jia on 12/2/16.
 */
public class BracketValidator {

    private static int size;
    private static char[] stack;

    public static void main(String[] args) {
        System.out.println(isValid("{ [ ] ( ) }"));     //true
        System.out.println(isValid("{ [ (asdfasdf ])}"));   //false
        System.out.println(isValid("{addda [asd }asd"));    //false
    }

    private static boolean isValid(String code) {

        if (code == null || code.length() == 0) {
            return true;
        }

        stack = new char[code.length()/2];
        size = 0;

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                push(c);
            } else if (c == ']' || c == ')' || c == '}') {
                char p = pop();
                if (c == ']' && p != '[') {
                    return false;
                } else if (c == ')' && p != '(') {
                    return false;
                } else if (c == '}' && p != '{') {
                    return false;
                }
            }
        }

        if (getSize() > 0) {
            return false;
        }

        return true;
    }

    private static char pop() {
        if (size > 0 && size < stack.length) {
            size --;
            return stack[size];
        }

        throw new IllegalArgumentException("can't pop");
    }

    private static void push(char c) {
        if (size >= stack.length) {
            throw new IllegalArgumentException("stack full");
        } else {
            stack[size] = c;
            size ++;
        }
    }

    public static int getSize() {
        return size;
    }
}
