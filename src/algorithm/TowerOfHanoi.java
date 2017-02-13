package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitse on 11/28/15.
 *
 * https://www.tutorialspoint.com/data_structures_algorithms/tower_of_hanoi.htm
 */
public class TowerOfHanoi {

    public static List<Peg> pegs;
    public static int moves;

    public static void main(String[] args) {
        pegs = new ArrayList<>();

        pegs.add(new Peg("A"));
        pegs.add(new Peg("B"));
        pegs.add(new Peg("C"));
        pegs.add(new Peg("D"));
        pegs.add(new Peg("E"));
        pegs.add(new Peg("F"));
        pegs.add(new Peg("G"));
        pegs.add(new Peg("H"));
        pegs.add(new Peg("I"));

        int moves = 0;
        solve(pegs.size()-1, TOWER.TOWER1, TOWER.TOWER2, TOWER.TOWER3);

    }

    private static void solve(int n, TOWER src, TOWER aux, TOWER dest) {
        if (n < 0) {
            return;
        } else {
            //there are 3 steps done in a recursive manner:

            //1) move n-1 disks from the src peg to the aux peg (treating the dest peg as "aux");
            solve (n-1, src, dest, aux);

            //2) move the nth disk over to the dest peg
            System.out.println(++moves + ":  Moving " + pegs.get(n).name + " from " + src + " to " + dest);

            //3) now move the n-1 that's in the aux peg (from step 1) to the dest peg (using src as "aux"0)
            solve (n-1, aux, src, dest);
        }
    }


    static enum TOWER {

        TOWER1("Tower 1"), TOWER2("Tower 2"), TOWER3("Tower 3");

        String value;

        private TOWER(String s) {
            value = s;
        }
    }

    static class Peg {
        public String name;

        public Peg(String name) {
            this.name = name;
        }
    }
}
