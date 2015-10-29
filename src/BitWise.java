/**
 * User: jitse
 * Date: 10/23/15
 * Time: 8:36 PM
 */
public class BitWise {

    public static void main(String[] args) {
        int i = 3;  //11
        int j = 5;  //101

        System.out.println(i & j);      //AND 001 == 1
        System.out.println(i | j);      //OR 111 == 7
        System.out.println(i ^ j);      //XOR 110 == 6

        System.out.println(j >> 1);     //10 == 2
        System.out.println(j << 1);     //1010 == 10

        System.out.println("==============================");
        highLevelBitOfByte();
    }


    /**
     * This checks whether the high level bit of a byte is set. A byte has 8 bits: 11111111.
     * The MSB, if set, is 128. So we take the number, AND it when 128, and if the resulting number is  128, then the
     * MSB was set.
     */
    public static void highLevelBitOfByte() {
        System.out.println(128 & 128);  //This should be 128, so true
        System.out.println(140 & 128);
        System.out.println(150 & 128);
        System.out.println(160 & 128);
        System.out.println(180 & 128);
        System.out.println(200 & 128);
        System.out.println(50 & 128);       //no, it should be zero
    }
}
