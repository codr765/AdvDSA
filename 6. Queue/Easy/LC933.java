import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.add(t);

        while (q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }
}