package algorithm;

/**
 *
 * Write a method to decide if two strings are anagrams or not.
 *
 * User: jitse
 * Date: 7/12/15
 * Time: 3:55 PM
 */
public class Anagram {

    static int array1[];
    static int array2[];

    public static void main(String[] args) {

        String word1 = "stop";
        String word2 = "post";
        System.out.println(word1 + "," + word2 + ": " + isAnagram(word1, word2));

        word1 = "asdf";
        word2 = "asdf";
        System.out.println(word1 + "," + word2 + ": " + isAnagram(word1, word2));


        word1 = "asdfsadf";
        word2 = "asdf";
        System.out.println(word1 + "," + word2 + ": " + isAnagram(word1, word2));


        word1 = "asdfasdf";
        word2 = "asdfsfax";
        System.out.println(word1 + "," + word2 + ": " + isAnagram(word1, word2));

        word1 = "asdfasdf";
        word2 = "aassddff";
        System.out.println(word1 + "," + word2 + ": " + isAnagram(word1, word2));
    }

    public static boolean isAnagram(String w1, String w2) {
        array1 = new int[256];
        array2 = new int[256];

        if (w1.length() != w2.length()) {
            return false;
        }

        if (w1 == null && w2 == null) {
            return true;
        } else if (w1 == null || w2 == null) {
            return false;
        }

        for (int i=0; i<w1.length(); i++) {
            array1[w1.charAt(i)]++;
            array2[w2.charAt(i)]++;
        }

        for (int i=0; i<256; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }


        return true;
    }
}
