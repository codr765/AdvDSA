import java.util.Arrays;

public class SudukoSolver {

    static boolean isValid(int[][] board, int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solver(int[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solver(board, row + 1, 0);
        }

        if (board[row][col] != 0) {
            return solver(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;

                if (solver(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },

                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },

                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        if (solver(board, 0, 0)) {
            for (int[] is : board) {
                System.out.println(Arrays.toString(is));
            }
        } else {
            System.out.println("Not Solvable.");
        }
    }
}
