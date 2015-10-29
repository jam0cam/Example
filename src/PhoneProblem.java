import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Write a program that, given a phone number, return all possible letter combinations that can be formed. Eg.
 * Given 23 The following letter combinations can be formed: “AD”, “AE”, “AF”, “BD”, “BE”, “BF”, “CD”, “CE”, “CF”.
 *
 * Given 234 The following letter combinations can be formed:
 * “ADG”,”ADH”,”ADI”,”AEG”,”AEH”,”AEI”,”AFG”, “AFH”,”AFI”,”BDG”,”BDH”,”BDI”,”BEG”,”BEH”,
 * “BEI”,”BFG”,”BFH”,”BFI”,”CDG”,”CDH”,”CDI”, “CEG”,”CEH”,”CEI”,”CFG”,”CFH”,”CFI”.
 *
 * REF: https://algorithmstuff.wordpress.com/tag/letter-combinations-of-a-phone-number/
 *
 * User: jitse
 * Date: 10/25/15
 * Time: 7:01 PM
 */
public class PhoneProblem {

    static String[] arr = {
            "",
            "",
            "ABC",
            "DEF",
            "GHI",
            "JKL",
            "MNO",
            "PQRS",
            "TUV",
            "WXYZ"
    };

    public static void main(String[] args) {
        List<String> rval;

        rval = phone("23");
        print(rval);

        System.out.println("========================");

        rval = phone("234");
        print(rval);

        System.out.println("========================");

        rval = phone("120");
        print(rval);

    }

    static void print(List<String> list) {
        for (String s : list) {
            System.out.print("\"" + s + "\",");
        }

        System.out.println();
    }

    static List<String> phone(String digits) {
        List<String> rval = new ArrayList<>();

        if (digits.length() == 1) {
            for (int i=0; i< arr[getInt(digits)].length(); i++) {
                rval.add(String.valueOf(arr[getInt(digits)].charAt(i)));
            }

            return rval;
        }

        //take the first digit and recurse the rest
        char c = digits.charAt(0);
        for (int i=0; i<arr[getInt(String.valueOf(c))].length(); i++) {
            List<String> phones = phone(digits.substring(1, digits.length()));

            for (String p : phones) {
                String s = arr[getInt(String.valueOf(c))].charAt(i) + p;
                rval.add(s);
            }
        }

        return rval;
    }

    static int getInt(String s) {
        return Integer.parseInt(s);
    }
}
