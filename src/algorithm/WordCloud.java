package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * You want to build a word cloud, an infographic where the size of a word corresponds to how often it
 * appears in the body of text. Assume the input will only contain words and standard punctuation.
 *
 * https://www.interviewcake.com/question/java/word-cloud
 *
 * Created by Jia on 11/21/16.
 */
public class WordCloud {

    public static final String input1 =  "After beating the eggs, Dana read the next step:";
    public static final String input2 =  "Add milk and eggs, then add flour and sugar.";
    public static final String input3 =  "Add milk-buns and eggs, then add flour-buns and milk-buns sugar.";
    public static final String input4 =  "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.";
    public static final String input5 =  "The bill came to five dollars.";

    public static void main(String[] args) {

        Map<String, Integer> result = solve(input1);
        printMap(result);
        System.out.println("========================");
        result = solve(input2);
        printMap(result);
        System.out.println("========================");
        result = solve(input3);
        printMap(result);
        System.out.println("========================");
        result = solve(input4);
        printMap(result);
        System.out.println("========================");
        result = solve(input5);
        printMap(result);

    }

    private static void printMap(Map<String, Integer> map) {
        Set<String> strings = map.keySet();
        for (String key : strings) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    private static Map<String, Integer> solve(String input) {
        if (input == null) {
            return null;
        }

        String[] words = input.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            word = word.replaceAll("[!@#$%^,&*()<>?:.]", "").toLowerCase().trim();
            if (word.length() > 0) {
                Integer val = map.get(word);
                if (val == null) {
                    map.put(word, 1);
                } else {
                    map.put(word, val +1);
                }
            }
        }

        return map;
    }

}
