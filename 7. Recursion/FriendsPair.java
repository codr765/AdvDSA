public class FriendsPair {

    static int total(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return total(n - 1) + (n - 1) * total(n - 2);
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(total(n));
    }
}