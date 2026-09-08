public class CountComma {
    static int countCommas(int n) {

        if (n < 1000) {
            return 0;
        }

        return n - 999;
    }

    public static void main(String[] args) {

    }
}
