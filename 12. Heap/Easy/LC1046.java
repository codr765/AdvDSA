import java.util.Collections;
import java.util.PriorityQueue;

public class LC1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            pq.add(i);
        }

        while (pq.size() != 1) {
            int curr = Math.abs(pq.poll() - pq.poll());
            pq.add(curr);
        }

        return pq.poll();
    }
}
