import java.util.ArrayList;
import java.util.List;

/**
 *
 * Write an algorithm to print all ways of arranging eight queens on a chess board so that none of them share the same row, column or diagonal.
 *
 * User: jitse
 * Date: 9/21/15
 * Time: 9:15 AM
 */
public class EightQueenProblem {

    static int board[][] = new int[8][8];
    static List<int[][]> completedBoards;

    public static void main(String[] args) {
        completedBoards = new ArrayList<>();
        dropPiece(0);
        System.out.println("Total boards: " + completedBoards.size());
    }

    public static void dropPiece(int row) {
        if (row >= 8) {
            completedBoards.add(board);
            System.out.println("completed board");
            return;
        }

        for (int i=0; i<8; i++) {   //going through the columns
            if (!isConflict(row, i)) {
                board[row][i] = 1;
                dropPiece(row+1);
                board[row][i] = 0;
            }
        }

        System.out.println("INCOMPLETE board");
    }

    private static boolean isConflict(int row, int col) {

        //check rows and columns
        for (int i=0; i<8; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return true;
            }
        }

        //check diagonals
        int x = row;
        int y = col;

        while (x >=0 && y>=0) {
            if (board[x][y] == 1) {
                return true;
            }

            x--;
            y--;
        }

        x = row;
        y = col;
        while (x <8 && y<8) {
            if (board[x][y] == 1) {
                return true;
            }

            x++;
            y++;
        }

        x = row;
        y = col;
        while (x >=0 && y<8) {
            if (board[x][y] == 1) {
                return true;
            }

            x--;
            y++;
        }

        x = row;
        y = col;
        while (x < 8 && y>=0 ) {
            if (board[x][y] == 1) {
                return true;
            }
            x++;
            y--;
        }

        return false;
    }
}
