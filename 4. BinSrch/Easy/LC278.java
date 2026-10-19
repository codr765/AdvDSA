public class LC278 {

    static boolean isBadVersion(int n) {
        if (n == 4) {
            return true;
        }

        return false;
    }

    static int firstBadVersion(int n) {
        int first = -1;

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                first = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return first;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(firstBadVersion(n));
    }
}
