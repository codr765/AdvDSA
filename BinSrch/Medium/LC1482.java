public class LC1482 {
    static int minDays(int[] bloomDay, int m, int k) {
        int min = -1;

        int left = 0;
        int right = 0;

        int count = 0;

        for (int i : bloomDay) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }

        while (left < right) {

        }

        return min;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;

        System.out.println(minDays(bloomDay, m, k));
    }
}
