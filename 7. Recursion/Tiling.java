public class Tiling {

    static int total(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return total(n - 1) + total(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(total(n));
    }
}
