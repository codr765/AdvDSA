import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        int intervals = 0;

        int[] frq = new int[26];

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> frq[b - 'a'] - frq[a - 'a']);

        for (char ch : tasks) {
            frq[ch - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frq[i] > 0) {
                pq.add((char) (i + 'A'));
            }
        }

        Queue<int[]> q = new LinkedList<>();

        while (!pq.isEmpty() || !q.isEmpty()) {

            intervals++;

            if (!pq.isEmpty()) {
                char tmp = pq.poll();
                frq[tmp - 'A']--;

                if (frq[tmp - 'A'] > 0) {
                    q.offer(new int[] { tmp, intervals + n });
                }
            }

            if (!q.isEmpty() && q.peek()[1] == intervals) {
                pq.offer((char) q.poll()[0]);
            }
        }

        return intervals;
    }
}