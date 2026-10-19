public class LC374 {
    static int picked = 6;

    static int guess(int num) {
        if (num == picked) {
            return 0;
        }

        if (num > picked) {
            return -1;
        }

        return 1;
    }

    static int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(guessNumber(n));
    }
}