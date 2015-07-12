import java.util.Random;
import java.util.Scanner;

/**
 * User: jitse
 * Date: 10/18/14
 * Time: 9:28 PM
 */
public class Exercise43 {
    static Random randomGenerator = new Random();

    public static void main(String[] args) {
        System.out.println("Enter the target number. It needs to be 2.");

        Scanner scanner = new Scanner(System.in);
        int targetNumber = scanner.nextInt();
        int timesRolled = rollDice(targetNumber);

        System.out.println(timesRolled + " roll(s) was needed to reach " + targetNumber);
    }

    public static int rollDice(int targetNumber) {
        int timesRolled = 0;
        int sum = 0;
        while (sum != targetNumber) {
            int firstNumber = randomGenerator.nextInt(6) + 1;
            int secondNumber = randomGenerator.nextInt(6) + 1;
            sum = firstNumber + secondNumber;
            timesRolled ++;
        }

        return timesRolled;
    }
}
