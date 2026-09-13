import java.util.Arrays;

public class Q1 {

    static void rev(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    static void rotateColumnUp(int[][] grid, int col, int k) {
        int n = grid.length;
        k %= n;

        int start = 0;
        int end = k - 1;

        while (start < end) {
            int tmp = grid[start][col];
            grid[start][col] = grid[end][col];
            grid[end][col] = tmp;
            start++;
            end--;
        }

        start = k;
        end = n - 1;

        while (start < end) {
            int tmp = grid[start][col];
            grid[start][col] = grid[end][col];
            grid[end][col] = tmp;
            start++;
            end--;
        }

        start = 0;
        end = n - 1;

        while (start < end) {
            int tmp = grid[start][col];
            grid[start][col] = grid[end][col];
            grid[end][col] = tmp;
            start++;
            end--;
        }
    }

    static int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        for (int i = 0; i < rowShift.length; i++) {

            int k = rowShift[i] % grid[i].length;

            rev(grid[i], 0, k - 1);
            rev(grid[i], k, grid[i].length - 1);
            rev(grid[i], 0, grid[i].length - 1);

        }

        for (int i = 0; i < colShift.length; i++) {
            rotateColumnUp(grid, i, colShift[i]);
        }

        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] rowShift = { 1, 2, 0 };
        int[] colShift = { 2, 2, 1 };
        int n = grid.length;

        cyclicShift(n, grid, rowShift, colShift);

        for (int i[] : grid) {
            System.out.println(Arrays.toString(i));
        }

    }
}
