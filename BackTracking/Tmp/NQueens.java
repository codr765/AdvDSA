import java.util.Arrays;

public class NQueens {

    static void fill(char[][] board, int row) {
        if (row == board.length) {

            System.out.println();

            for (char[] cs : board) {
                System.out.println(Arrays.toString(cs));
            }

            return;
        }

        for (int col = 0; col < board.length; col++) {
            board[row][col] = 'Q';

            fill(board, row + 1);

            board[row][col] = '.';
        }
    }

    static void nQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] cs : board) {
            Arrays.fill(cs, '.');
        }

        fill(board, 0);

    }

    public static void main(String[] args) {
        int n = 5;

        nQueens(n);
    }
}
