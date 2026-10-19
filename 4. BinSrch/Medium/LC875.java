public class LC875 {
    static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int i : piles) {
            right = Math.max(right, i);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int totalHours = 0;

            for (int i : piles) {
                totalHours += (int) Math.ceil((double) i / mid);
            }

            if (totalHours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };

        System.out.println(minEatingSpeed(piles, 8));
    }
}