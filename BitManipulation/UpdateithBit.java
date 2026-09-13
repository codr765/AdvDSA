public class UpdateithBit {
    static int updateithBit(int n, int i, int newBit) {
        n = n & ~(1 << i);

        return n | (newBit << i);
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println(updateithBit(n, 3, 1));
    }
}
