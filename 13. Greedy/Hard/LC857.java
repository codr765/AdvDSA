import java.util.Arrays;
import java.util.PriorityQueue;

public class LC857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        int n = quality.length;

        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int sum = 0;
        double ans = Double.MAX_VALUE;

        for (double[] worker : workers) {

            int q = (int) worker[1];
            double ratio = worker[0];

            pq.add(q);
            sum += q;

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.min(ans, sum * ratio);
            }
        }

        return ans;
    }
}