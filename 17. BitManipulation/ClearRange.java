public class ClearRange {
    static int clearRange(int n, int i, int j) {
        int mask = (-1 << j + 1) | ((1 << i) - 1);

        return n & mask;
    }

    public static void main(String[] args) {
        int n = 63;

        System.out.println(clearRange(n, 4, 9));
    }
}
