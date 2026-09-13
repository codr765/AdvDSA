public class SetithBit {
    static int setithBit(int n, int i) {
        return n | (1 << i);
    }

    public static void main(String[] args) {
        int n = 35;

        System.out.println(setithBit(n, 4));
    }
}
