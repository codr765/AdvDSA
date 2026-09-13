public class ClearRange {
    static int clearLastiBits(int n, int i) {
        return n & (-1 << i);
    }

    public static void main(String[] args) {
        int n = 63;

        System.out.println(clearLastiBits(n, 4));
    }
}
