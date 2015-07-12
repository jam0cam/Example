/**
 * User: jitse
 * Date: 8/29/14
 * Time: 8:02 PM
 */
public class Test {

    public static void main(String[] args) {

        String word = "hello world";
        char c = word.charAt(4);

        System.out.println(c == word.charAt(7));




        StringBuilder sb = new StringBuilder();


        for (int i=word.length() -1 ;i>= 0; i--) {
            sb.append(word.charAt(i));
        }


        System.out.println(sb.toString());
    }
}
