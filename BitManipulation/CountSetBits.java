public class CountSetBits {
    static int count(int n) {
        int total = 0;

        while (n > 0) {

            // if ((n & 1 )== 1) {
            // total++;
            // }

            n = n & (n - 1);

            // n = n >> 1;
        }

        return total;
    }

    public static void main(String[] args) {
        int n = 57;

        System.out.println(count(n));
    }
}
