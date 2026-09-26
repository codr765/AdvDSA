import java.util.Arrays;

public class PlaceQ {

    static boolean isSafe(char[][] board, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int prevRow = row - 1;
        int prevCol = col - 1;

        while (prevRow >= 0 && prevCol >= 0) {
            if (board[prevRow][prevCol] == 'Q') {
                return false;
            }

            prevRow--;
            prevCol--;
        }

        int nextRow = row - 1;
        int nextCol = col + 1;

        while (nextRow >= 0 && nextCol < board[0].length) {
            if (board[nextRow][nextCol] == 'Q') {
                return false;
            }

            nextRow--;
            nextCol++;
        }

        return true;
    }

    static void fill(char[][] board, int row) {

        if (row == board.length) {

            System.out.println();

            for (char[] cs : board) {
                System.out.println(Arrays.toString(cs));
            }

            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                fill(board, row + 1);

                board[row][col] = ' ';
            }
        }
    }

    static void place(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ' ');
        }

        fill(board, 0);
    }

    public static void main(String[] args) {
        place(4);
    }
}