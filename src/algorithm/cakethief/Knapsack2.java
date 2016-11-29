package algorithm.cakethief;

/**
 * Cake Thief
 *
 * You are a renowned thief who has recently switched from stealing precious metals to stealing cakes because of
 * the insane profit margins. You end up hitting the jackpot, breaking into the world's largest privately owned
 * stock of cakes—the vault of the Queen of England.
 *
 * While Queen Elizabeth has a limited number of types of cake, she has an unlimited supply of each type
 *
 * Each type of cake has a weight and a value, stored in objects of a CakeType class.
 *
 * Example:
 * // weighs 7 kilograms and has a value of 160 pounds
 * new CakeType(7, 160);
 *
 * You brought a duffel bag that can hold limited weight, and you want to make off with the most valuable haul possible.
 *
 * Write a function maxDuffelBagValue() that takes an array of cake type objects and a weight capacity, and returns
 * the maximum monetary value the duffel bag can hold.
 *
 * Weights and values may be any non-negative integer. Yes, it's weird to think about cakes that weigh nothing or
 * duffel bags that can't hold anything. But we're not just super mastermind criminals—we're also meticulous
 * about keeping our algorithms flexible and comprehensive.
 *
 * https://www.interviewcake.com/question/java/cake-thief
 * http://t.dripemail2.com/c/eyJhY2NvdW50X2lkIjoiNDc3NDM4NCIsImRlbGl2ZXJ5X2lkIjoiMzMwNzQxODg1IiwidXJsIjoiaHR0cHM6Ly93d3cuaW50ZXJ2aWV3Y2FrZS5jb20vcXVlc3Rpb24vY2FrZS10aGllZj9fX3M9NnViYW9vYXk0dDNiMmo0c3E4Z3AifQ
 *
 */
public class Knapsack2 {

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;

        //answer is 555
        System.out.println(maxDuffelBagValue(cakeTypes, capacity));


        //no cakes, and no capacity, should be zero
        System.out.println(maxDuffelBagValue(new CakeType[]{}, 0));

        //1 cake with no weight and no value, and no capacity, should be zero
        System.out.println(maxDuffelBagValue(new CakeType[]{new CakeType(0,0)}, 0));

        //104
        System.out.println(maxDuffelBagValue(new CakeType[]{
                new CakeType(5,50),
                new CakeType(3,27),
        }, 11));


    }

    private static int maxDuffelBagValue(final CakeType[] cakeTypes, final int capacity) {

        int[] max = new int[capacity +1];
        int[][] table = new int[cakeTypes.length][capacity+1];

        for (int y=0; y<=capacity; y++) {
            int localMax = 0;
            for (int x=0; x<cakeTypes.length; x++) {
                if (cakeTypes[x].weight > y) {
                    //the weight is greater than capacity, so can't hold it.
                    table[x][y] = 0;
                } else {
                    //we can hold one of these, plus the max of whatever that was before this item is added
                    table[x][y] = cakeTypes[x].value + max[y - cakeTypes[x].weight];
                }

                if (localMax < table[x][y]) {
                    localMax = table[x][y];
                }
            }

            max[y] = localMax;
        }

        return max[capacity];
    }
}
