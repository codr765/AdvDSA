import java.util.Arrays;
import java.util.PriorityQueue;

public class LC2402 {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available = new PriorityQueue<>();

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }

            return Long.compare(a[1], b[1]);
        });

        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {

                int room = available.poll();

                busy.offer(new long[] { end, room });
                count[room]++;

            } else {

                long[] curr = busy.poll();

                long freeTime = curr[0];
                int room = (int) curr[1];

                long duration = end - start;
                long newEnd = freeTime + duration;

                busy.offer(new long[] { newEnd, room });
                count[room]++;
            }
        }

        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}