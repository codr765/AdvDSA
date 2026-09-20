import java.util.Arrays;

public class C620Q2 {

    static int countIntersectingIntervals(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = intervals[i][1];
        }

        Arrays.sort(ends);

        int count = 0;
        int expired = 0;

        for (int i = 0; i < n; i++) {

            int start = intervals[i][0];

            while (expired < n && ends[expired] < start) {
                expired++;
            }

            count += i - expired;
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 }
        };

        System.out.println(countIntersectingIntervals(intervals));
    }
}