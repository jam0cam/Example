package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, find the longest substring such that there is at most M repeated characters.
 *
 * ie: abbbcabcbdde, M=3 ==> 9
 *
 * Created by jtse on 2/16/17.
 */
public class LongestSubArrayMUnique {


    public static void main(String[] args) {

    }

    /**
     * The idea is to have a left and right pointer, using a sliding window technique. Every time we encounter a new
     * character, if we haven't exceeded M unique characters in the map, then we add it to the map. If we already
     * exceeded, then we evict one out of the map and put the new one in (and recalculate the new substring lengths).
     *
     * Map stores the character, and the index at which it was seen last.
     *
     * @param str
     * @param m
     * @return
     */
    static String solve(String str, int m) {
        if (str == null) {
            return null;
        }

        Map<String, Integer> map = new HashMap<>();
        int pointer = 0;
        String maxString = "";

        for (int i=0; i<str.length(); i++) {
            String a = String.valueOf(str.charAt(i));

            if (map.get(a) != null) {
                //this character has already been seen, we can safely move on and increase the length
                map.put(a, i);
            } else {
                //this is a new character.
                if (map.keySet().size() < m) {
                    //we still have room to store more unique characters. Just insert and move on
                    map.put(a, i);
                } else {
                    //there isn't enough room, we have to evict a character, and update the left pointer
                    pointer = evict(map);
                    map.put(a, i);
                }
            }
        }


    }

    /**
     * Looks through all entries, and for the entry with the smallest index, that's the entry will be evicted.
     * @param map
     */
    static int evict(Map<String, Integer> map) {
        String keyToDelete = null;
        int minValue = Integer.MAX_VALUE;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (keyToDelete == null) {
                keyToDelete = key;
                minValue = value;
            } else {
                if (value < minValue) {
                    minValue = value;
                    keyToDelete = key;
                }
            }
        }

        map.remove(keyToDelete);
        //this is the index of the value, which is what the pointer should be pointing to;
        return minValue;
    }
}
