public class GetithBit {
    static int getithBit(int n, int i) {
        return (n & (1 << i)) == 0 ? 0 : 1;
    }
    public static void main(String[] args) {
        int n = 42;

        for (int i = 0; i < 12; i++) {
            System.out.println(getithBit(n, i));
        }
    }
}
