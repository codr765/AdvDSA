public class GetLastBit {
    static int getLastBit(int n) {
        return n & 1;
    }

    public static void main(String[] args) {
        int n = 6;

        System.out.println(getLastBit(n));
    }
}
