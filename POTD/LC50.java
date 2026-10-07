public class LC50 {
    static double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }

        double ans = myPow(x, n / 2);

        if (n % 2 == 0) {
            return ans * ans;
        }

        return ans * ans * x;
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;

        System.out.println(myPow(x, n));
    }
}
