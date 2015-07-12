import java.util.Scanner;

/**
 * User: jitse
 * Date: 10/17/14
 * Time: 6:08 PM
 */
public class Exercise34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //reads a line of input
        String line = scanner.nextLine();

        //loop through every character of the line. If a character is not a letter, then print a new line and start writing
        //when the next letter is found
        for (int i=0; i<line.length(); i++) {
            char currentLetter = line.charAt(i);
            if (Character.isLetter(currentLetter)) {
                //this is a letter, so print it on the screen
                System.out.print(currentLetter);
            } else {
                //Found something that is not a letter. We can print a new line now.
                System.out.println();

                //we need to keep skipping non-letters until we actually find a real letter
                while (!Character.isLetter(currentLetter)) {
                    //this increases i by 1, so we are looking at the next character now
                    i = i+1;

                    //we need to be careful. If i >= line.length, that means we are at the end of the string.
                    //We can just exit everything and end the program.
                    if (i >= line.length()) {
                        break;
                    }
                    currentLetter = line.charAt(i);
                }

                //the while loop exits when a letter is found. We have to decrement i by 1 because at the end of the for loop
                //i will be incremented by 1.
                i = i-1;
            }
        }
    }
}
