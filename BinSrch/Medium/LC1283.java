public class LC1283 {
    static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i : nums) {
            right = Math.max(right, i);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int ans = 0;

            for (int i : nums) {
                ans = ans + (int) (Math.ceil((double) i / mid));
            }

            if (ans > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
}
