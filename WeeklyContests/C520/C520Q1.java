public class C520Q1 {
    static int countIntersectingIntervals(int[][] intervals) {
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {

                if (intervals[i][0] <= intervals[j][1] &&
                        intervals[j][0] <= intervals[i][1]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 5 }, { 2, 4 }, { 3, 6 } };

        System.out.println(countIntersectingIntervals(intervals));
    }
}
