import java.util.Arrays;

public class LC1109 {
    static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] total = new int[n];

        // for (int[] i : bookings) {
        // for (int j = i[0] - 1; j < i[1]; j++) {
        // total[j] += i[2];
        // }
        // }

        for (int[] booking : bookings) {
            total[booking[0] - 1] += booking[2];

            if (booking[1] + 1 < n) {
                total[booking[1] + 1] -= booking[2];
            }
        }

        for (int i = 1; i < total.length; i++) {
            total[i] += total[i - 1];
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int n = 5;

        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }
}
