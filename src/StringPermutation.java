import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 7/26/15
 * Time: 7:07 PM
 */
public class StringPermutation {

    static String name = "SKY";

    public static void main(String[] args) {
        List<String> results = permute(name);
        print(results);
    }

    static void print(List<String> strings) {
        for (String s : strings) {
            System.out.println(s);
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
                List<String> inserted = insert(head, s);
                rval.addAll(inserted);
            }

            return rval;
        }
    }

    private static List<String> insert(char head, String s) {
        List<String> rval = new ArrayList<>();

        if (s == null || s.length() == 0) {
            rval.add(String.valueOf(head));
            return rval;
        } else if (s.length() == 1) {
            rval.add(head + s);
            rval.add(s + head);
            return rval;
        } else {
            //more than one character in length
            for (int i=0; i<=s.length(); i++) {
                String firstHalf = s.substring(0, i);
                String secondHalf = s.substring(i, s.length());
                rval.add(firstHalf + head + secondHalf);
            }

            return rval;
        }


    }

}
