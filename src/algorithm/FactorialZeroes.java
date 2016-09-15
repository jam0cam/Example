package algorithm;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * 26! has 6 zeroes
 *
 *
 * reference: http://www.purplemath.com/modules/factzero.htm
 * reference: http://www.programmerinterview.com/index.php/java-questions/find-trailing-zeros-in-factorial/
 *
 * User: jitse
 * Date: 9/22/15
 * Time: 3:01 PM
 */
public class FactorialZeroes {

    public static void main(String[] args) {
        System.out.println(calculate(26));
        System.out.println(calculate(29));
        System.out.println(calculate(101));
        System.out.println(calculate(23));
        System.out.println(calculate(1000));
        System.out.println(calculate(4617));
    }


    public static int calculate(int n) {
        int rval = n/5;

        int i=2;
        while (Math.pow(5,i) < n) {
            rval += n/Math.pow(5,i);
            i++;
        }

        return rval;
    }
}
