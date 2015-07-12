import java.util.Scanner;

/**
 * User: jitse
 * Date: 9/18/14
 * Time: 9:38 PM
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            double number1 = scanner.nextDouble();
            if (number1 == 0) {
                break;
            }
            String operator = scanner.next();
            double number2 = scanner.nextDouble();

            if (operator.equals("*")) {
                System.out.println(number1 * number2);
            } else if (operator.equals("/")) {
                System.out.println(number1 / number2);
            } else if (operator.equals("-")) {
                System.out.println(number1 - number2);
            } else {
                System.out.println(number1 + number2);
            }
        }
    }
}
