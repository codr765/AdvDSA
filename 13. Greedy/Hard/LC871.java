import java.util.PriorityQueue;

public class LC871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int fuel = startFuel;
        int stops = 0;
        int i = 0;

        while (fuel < target) {

            while (i < stations.length && stations[i][0] <= fuel) {
                pq.add(stations[i][1]);
                i++;
            }

            if (pq.isEmpty()) {
                return -1;
            }

            fuel += pq.poll();
            stops++;
        }

        return stops;
    }
}