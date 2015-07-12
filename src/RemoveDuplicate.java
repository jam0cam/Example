/**
 *
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer.
 *
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 *
 * User: jitse
 * Date: 7/12/15
 * Time: 1:32 PM
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        String word = "h";
//        String word = "hh";
//        String word = "hello world";
        System.out.println(removeDuplicates(word.toCharArray()));
    }

    private static char[] removeDuplicates(char[] str) {
        int len = str.length;
        int carat = 1;

        for (int i=1; i<len; i++) {
            char newChar = str[i];
            boolean duplicateFound = false;
            for (int x=0; x<carat; x++) {
                if (newChar == str[x]) {
                    duplicateFound = true;
                    break;
                }
            }

            if (!duplicateFound) {
                str[carat] = newChar;
                carat++;
            }
        }

        //zero out remaining spaces;
        for (int i=carat; i< len; i++) {
            str[i] = 0;
        }

        return str;
    }
}
