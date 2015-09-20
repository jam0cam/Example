/**
 * User: jitse
 * Date: 7/14/15
 * Time: 5:11 PM
 */
public class ZeroOut {

    static int[][] mMatrix = {
            {5, 2, 3, 1, 1},
            {2, 2, 1, 3, 5},
            {2, 2, 1, 3, 5},
            {4, 2, 1, 3, 5},
            {2, 2, 3, 3, 1},
            {5, 1, 3, 0, 4},
            {2, 2, 0, 4, 5},
            {5, 2, 1, 3, 1},
    };

    static int[][] mCopyMatrix;

    private static int[][] cloneArray(int[][] arr) {
        int[][] rval = new int[arr.length][arr[0].length];

        for (int y = 0; y < arr.length; y++) {
            for (int x=0; x<arr[0].length; x++) {
                rval[y][x] = arr[y][x];
            }
        }

        return rval;
    }

    public static void main(String[] args) {
        mCopyMatrix = cloneArray(mMatrix);
        printMatrix(mMatrix);
        zeroOut(mMatrix);
        System.out.println();
        printMatrix(mCopyMatrix);
    }

    private static void printMatrix(int[][] mat) {
        for (int x=0; x<mat.length; x++) {
            for (int y=0; y<mat[0].length; y++) {
                System.out.print(mat[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void zeroOut(int[][] matrix) {
        for (int y=0; y<matrix[0].length; y++) {
            for (int x=0; x<matrix.length; x++) {
                if (matrix[x][y] == 0) {
                    setZero(mCopyMatrix, x, y);
                }
            }
        }
    }

    private static void setZero(int[][] matrix, int i, int j) {

        for (int y=0; y<matrix[0].length; y++) {
            matrix[i][y] = 0;
        }

        for (int x=0; x<matrix.length; x++) {
            matrix[x][j] = 0;
        }
    }
}
