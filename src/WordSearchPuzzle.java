import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jitse on 1/6/16.
 */
public class WordSearchPuzzle {
    static String[][] input = {
            {"S", "I", "M", "A", "R", "C", "C", "E", "E", "T", "D", "N", "L", "T", "A"},
            {"P", "A", "E", "A", "K", "O", "C", "U", "O", "N", "A", "E", "P", "E", "R"},
            {"N", "U", "G", "A", "C", "A", "G", "M", "O", "P", "E", "C", "A", "N", "P"},
            {"G", "U", "M", "O", "T", "N", "I", "M", "R", "E", "P", "P", "E", "P", "B"},
            {"S", "I", "N", "P", "I", "A", "L", "C", "T", "S", "L", "U", "T", "O", "I"},
            {"R", "U", "N", "R", "K", "A", "U", "U", "C", "H", "E", "N", "A", "A", "S"},
            {"T", "S", "E", "G", "G", "I", "N", "G", "E", "O", "L", "O", "L", "T", "E"},
            {"H", "M", "N", "N", "E", "A", "N", "O", "D", "R", "A", "A", "O", "M", "S"},
            {"B", "U", "T", "T", "E", "R", "S", "C", "O", "T", "C", "H", "C", "E", "S"},
            {"K", "U", "G", "P", "T", "N", "B", "A", "B", "B", "T", "S", "O", "A", "A"},
            {"U", "S", "S", "S", "E", "U", "N", "R", "N", "R", "S", "M", "H", "L", "L"},
            {"C", "I", "N", "N", "A", "M", "O", "N", "E", "E", "A", "C", "C", "A", "O"},
            {"O", "M", "S", "N", "O", "O", "R", "A", "C", "A", "M", "N", "A", "S", "M"},
            {"R", "A", "N", "I", "S", "I", "A", "R", "E", "D", "D", "U", "A", "R", "R"},
    };

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("ALMOND");
        strings.add("BRAN");
        strings.add("BUTTERSCOTCH");
        strings.add("CHOCOLATE");
        strings.add("CINNAMON");
        strings.add("COCONUT");
        strings.add("GINGERBREAD");
        strings.add("MACAROONS");
        strings.add("MERINGUE");
        strings.add("MOLASSES");
        strings.add("OATMEAL");
        strings.add("PEANUT");

        strings.add("PECAN");
        strings.add("PEPPERMINT");
        strings.add("PUMPKIN");
        strings.add("RAISIN");
        strings.add("SHORTBREAD");
        strings.add("SUGAR");

        List<WordLocation> locations = solve(input, strings);

        System.out.println("The locations of the words are:");

        for (WordLocation wl : locations) {
            System.out.println(wl.word + ":" + "(" + wl.beginning.x + "," + wl.beginning.y + ") - " +
            "(" + wl.end.x + "," + wl.end.y + ")");
        }

    }

    static class WordLocation {
        public Point beginning;
        public Point end;
        public String word;

        public WordLocation(Point b, Point e, String w) {
            beginning = b;
            end = e;
            word = w;
        }
    }

    private static List<WordLocation> solve (String[][] puzzle, List<String> words) {
        List<WordLocation> rval = new ArrayList<>();

        // puzzle[y][x]
        for (int y=0; y<puzzle.length; y++) {
            for (int x=0; x<puzzle[y].length; x++) {

                System.out.print(puzzle[y][x]);

                for (String s : words) {
                    WordLocation location = match(puzzle, s, x,y);

                    if (location != null) {
                        if (!rval.contains(location)) {
                            rval.add(location);
                        }
                    }
                }
            }

            System.out.println();
        }

        return rval;

    }

    private static WordLocation match(String[][] puzzle, String toMatch, int x, int y) {

        //searches the right.
        WordLocation rval = matchWithDirection(puzzle, toMatch, x, y, 1, 0);

        if (rval == null) {
            //searches the diagonal right and bottom
            rval = matchWithDirection(puzzle, toMatch, x, y, 1, 1);
        }

        if (rval == null) {
            //searches the bottom
            rval = matchWithDirection(puzzle, toMatch, x, y, 0, 1);
        }


        if (rval == null) {
            //searches the diagonal bottom, left
            rval = matchWithDirection(puzzle, toMatch, x, y, -1, 1);
        }


        if (rval == null) {
            //searches the left
            rval = matchWithDirection(puzzle, toMatch, x, y, -1, 0);
        }


        if (rval == null) {
            //searches the top left
            rval = matchWithDirection(puzzle, toMatch, x, y, -1, -1);
        }

        if (rval == null) {
            //searches the top
            rval = matchWithDirection(puzzle, toMatch, x, y, 0, -1);
        }

        if (rval == null) {
            //searches the diagonal top right
            rval = matchWithDirection(puzzle, toMatch, x, y, 1, -1);
        }

        return rval;
    }

    private static WordLocation matchWithDirection(String[][] puzzle, String toMatch, int x, int y, int dx, int dy) {
        boolean found = true;
        Point begin = new Point(x,y);

        for (int i=0; i<toMatch.length(); i++) {
            int yIdx = y + i*dy;
            int xIdx = x + i*dx;


            if (xIdx >= 0 && yIdx >= 0 && xIdx < puzzle[y].length && yIdx < puzzle.length) {        //within bounds
                if (toMatch.charAt(i) != puzzle[yIdx][xIdx].charAt(0)) {
                    found = false;
                    break;
                }
            } else {
                found = false;
               break;
            }
        }

        if (found) {
            Point end = new Point(x + toMatch.length() * dx - dx, y+toMatch.length() * dy - dy);
            return new WordLocation(begin, end, toMatch);
        }

        return null;
    }
}
