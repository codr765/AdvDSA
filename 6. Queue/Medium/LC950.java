import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        int[] ans = new int[n];

        for (int card : deck) {
            int idx = q.poll();

            ans[idx] = card;

            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        return ans;
    }
}