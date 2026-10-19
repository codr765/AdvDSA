public class ClearithBit {
    static int clearithBit(int n, int i) {
        return n & ~(1 << i);
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(clearithBit(n, 4));
    }
}
