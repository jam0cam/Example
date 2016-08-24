package algorithm;

import java.util.Stack;

/**
 * Write a program that takes an input and determines whether the brackets are balanced correctly. Balanced correctly means that
 * for ever open bracket, there is a closed bracket that comes after it. Note that this is correct ()[] where as this is
 * incorrect: ([)].
 *
 * Created by jtse on 8/24/16.
 */
public class BracketMatcher {

    public static final String INPUT1 = "The (quick) [brown] {{fox()}} jumps [over{}] () the lazy ((dog)).";    //GOOD
    public static final String INPUT2 = "((())){{{}}}[[]]"; //GOOD
    public static final String INPUT3 = "The quick) [brown] {{fox()}} jumps [over{}] () the lazy ((dog))."; //BAD
    public static final String INPUT4 = "The (quick [brown] {{fox()}} jumps [over{}] () the lazy ((dog))."; //BAD
    public static final String INPUT5 = "The (quick) [brown] {{fox()}} jumps [over{}] () the lazy ((dog).";    //BAD
    public static final String INPUT6 = ")))(((";    //BAD
    public static final String INPUT7 = "([)]";    //BAD

    public static final String OPEN_BRACKETS = "{[(";
    public static final String CLOSE_BRACKETS = "}])";

    static Stack<String> mStack;

    public static void main(String[] args) {
        mStack = new Stack<>();

        System.out.println(solve(INPUT1) + ": should be TRUE");
        System.out.println(solve(INPUT2) + ": should be TRUE");
        System.out.println(solve(INPUT3) + ": should be FALSE");
        System.out.println(solve(INPUT4) + ": should be FALSE");
        System.out.println(solve(INPUT5) + ": should be FALSE");
        System.out.println(solve(INPUT6) + ": should be FALSE");
        System.out.println(solve(INPUT7) + ": should be FALSE");

    }

    static boolean solve(String input) {
        mStack.clear();

        if (input == null || input.length() == 0) {
            return true;
        }

        for (int i=0; i<input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));
            if (OPEN_BRACKETS.contains(letter)) {
                mStack.push(letter);
            } else if (CLOSE_BRACKETS.contains(letter)) {
                //now we pop until we find the matching bracket, or return false.
                boolean matchFound = false;
                while (!mStack.isEmpty()) {
                    String popped = mStack.pop();

                    if (isMatching(popped, letter)) {
                        matchFound = true;
                        break;
                    }
                }

                if (!matchFound) {
                    return false;
                }
            }
        }

        //by this point, ever closing bracket we saw have been matched by an open bracket.
        //now we just have to check for any open brackets left un accounted for.

        while (!mStack.isEmpty()) {
            String popped = mStack.pop();
            if (OPEN_BRACKETS.contains(popped)) {
                return false;
            }
        }


        return true;
    }


    static boolean isMatching(String open, String close) {

        for (int i=0; i<OPEN_BRACKETS.length(); i++) {
            if (open.equals(String.valueOf(OPEN_BRACKETS.charAt(i)))
                    && close.equals(String.valueOf(CLOSE_BRACKETS.charAt(i)))
                    ) {
                return true;
            }
        }

        return false;
    }
}
