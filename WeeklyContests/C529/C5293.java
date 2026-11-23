import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class C5293 {
    static long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        @SuppressWarnings("unchecked")
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(new int[] { edge[1], edge[2] });
        }

        long[] ans = new long[n];
        Arrays.fill(ans, -1);

        int[] count = new int[n];
        boolean[] active = new boolean[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0]));

        ans[0] = 0;
        active[0] = true;

        for (int[] edge : adj[0]) {
            pq.offer(new long[] { edge[1], edge[0] });
        }

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long time = curr[0];
            int node = (int) curr[1];

            if (active[node]) {
                continue;
            }

            count[node]++;

            if (count[node] == requiredSignals[node]) {

                active[node] = true;
                ans[node] = time;

                for (int[] edge : adj[node]) {
                    int next = edge[0];
                    int delay = edge[1];

                    if (!active[next]) {
                        pq.offer(new long[] { time + delay, next });
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1, 1 }, { 0, 2, 1 } };
        int[] req = { 1, 1, 2 };

        long[] a = earliestActivationTimes(n, edges, req);

        System.out.println(Arrays.toString(a));
    }
}
