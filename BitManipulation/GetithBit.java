public class GetithBit {

    static int findithBit(int n, int i) {
        return (n & (1 << i)) == 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        int n = 12;

        for (int i = 0; i < 4; i++) {
            System.out.println(findithBit(n, i));
        }
    }
}
