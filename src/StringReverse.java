/**
 * User: jitse
 * Date: 10/23/15
 * Time: 5:36 PM
 */
public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("hello world"));
    }

    private static String reverse(String s) {
        String rval = "";

        for (int i=s.length()-1; i>=0; i--) {
            rval += s.charAt(i);
        }

        return rval;
    }
}
