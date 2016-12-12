package algorithm;

/**
 * Write a function reverseWords() that takes a string message and reverses the order of the words in-place.
 *
 * Example:
 *   String message = "find you will pain only go you recordings security the into if";
 *
 * reverseWords(message);
 * // returns: "if into the security recordings you go only pain will you find"
 *
 * Created by Jia on 12/9/16.
 */
public class ReverseWords {

    public static void main(String[] args) {

        String message = "find you will pain only go you recordings security the into if";
        System.out.println(reverseWords(message));

        message = "   find you will pain only go you recordings security the into if       ";
        System.out.println(reverseWords(message));

        message = "  ";
        System.out.println(reverseWords(message));

        message = "face";
        System.out.println(reverseWords(message));
    }

    private static String reverseWords(String message) {
        if (message == null) {
            return null;
        }
        char[] msg = message.toCharArray();

        //step 1 reverse all characters O(n)
        int end = msg.length -1;
        reverseWord(msg, 0, end);

        //step 2 reverse each word O(n)
        int beginWordIndex = 0;
        for (int i=0; i<msg.length; i++) {
            if (i == msg.length -1) {
                reverseWord(msg, beginWordIndex, i);
                break;
            } else if (msg[i] == ' ') {
                reverseWord(msg, beginWordIndex, i-1);
                beginWordIndex = i+1;
            }
        }

        return new String (msg);
    }

    /**
     *
     * @param msg
     * @param begin inclusive
     * @param end inclusive
     */
    private static void reverseWord(char[] msg, int begin, int end) {
        while (begin < end) {
            char temp = msg[begin];
            msg[begin] = msg[end];
            msg[end] = temp;

            begin ++;
            end --;
        }
    }
}
