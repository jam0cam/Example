/**
 * User: jitse
 * Date: 7/13/15
 * Time: 5:15 PM
 */
public class Replace {
    public static void main (String[] args) {


        System.out.println(replaceSpace("hello world"));
        System.out.println(replaceSpace("this is great"));
        System.out.println(replaceSpace(""));
        System.out.println(replaceSpace("  "));
        System.out.println(replaceSpace(null));


        replaceSmart("hello world".toCharArray());

    }


    public static String replaceSpace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        String rval = "";

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != ' ') {
                rval += str.charAt(i);
            } else {
                rval += "%20";
            }
        }

        return rval;
    }


    public static String replaceSmart(char[] str) {

        System.out.println("length:" + str.length);
        str[120] = 's';

        return str.toString();
    }
}
