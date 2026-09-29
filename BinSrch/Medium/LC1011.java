public class LC1011 {
    static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int i : weights) {
            if (i > left) {
                left = i;
            }

            right += i;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int currWeight = 0;
            int currDays = 1;

            for (int i : weights) {
                if (currWeight + i > mid) {
                    currDays++;
                    currWeight = 0;
                }
                currWeight += i;
            }

            if (currDays > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
