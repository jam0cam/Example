package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * All sequence combinations of a string
 *
 1. --> 1 2 3 4 5
 2. --> 12 13 14 15 23 24 25 34 35 45
 3. --> 123 124 125 234 235 345
 4. --> 1234 1235 1245 1345 2345
 5. --> 12345

 * https://stackoverflow.com/questions/1617699/how-to-obtain-all-subsequence-combinations-of-a-string-in-java-or-c-etc/10861662#10861662
 *
 *
 * Created by jtse on 4/26/16.
 */
public class TryAllCombinations {

    public static void combinations(String suffix,String prefix){
        if(prefix.length()<0)return;
        System.out.println(suffix);
        for(int i=0;i<prefix.length();i++)
            combinations(suffix+prefix.charAt(i),prefix.substring(i+1,prefix.length()));
    }

    public static void main (String args[]){
        combinations("","12345");
    }
}
