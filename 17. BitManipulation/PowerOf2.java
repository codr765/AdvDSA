public class PowerOf2 {
    static boolean check(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 62;

        System.out.println(check(n));
    }
}