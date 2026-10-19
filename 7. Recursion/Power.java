public class Power {

    static int pow(int n, int p) {
        if (p == 0) {
            return 1;
        }

        if (p == 1) {
            return n;
        }

        int half = pow(n, p / 2);

        if (p % 2 == 0) {
            return half * half;
        }

        return n * half * half;
    }

    public static void main(String[] args) {
        int n = 2;
        int p = 10;

        System.out.println(pow(n, p));
    }
}