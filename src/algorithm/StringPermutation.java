package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 7/26/15
 * Time: 7:07 PM
 */
public class StringPermutation {

    static String name = "SKYM";

    public static void main(String[] args) {
        List<String> results = permute(name);
        print(results);
    }

    static void print(List<String> strings) {
        for (int i=0; i<strings.size(); i++) {
            System.out.println(i + ":" + strings.get(i));
        }
    }

    static List<String> permute(String word) {
        List<String> rval = new ArrayList<>();

        if (word.length() == 1) {
            rval.add(word);
            return rval;
        } else {
            char head = word.charAt(0);
            String rest = word.substring(1, word.length());

            List<String> result = permute(rest);

            for (String s : result) {

                for (int i=0; i<=s.length(); i++) {
                    String firstHalf = s.substring(0, i);
                    String secondHalf = s.substring(i, s.length());
                    rval.add(firstHalf + head + secondHalf);
                }
            }

            return rval;
        }
    }
}
