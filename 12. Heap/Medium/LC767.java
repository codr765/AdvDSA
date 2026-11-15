import java.util.PriorityQueue;

public class LC767 {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> freq[b - 'a'] - freq[a - 'a']);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();

            sb.append(first);
            sb.append(second);

            freq[first - 'a']--;
            freq[second - 'a']--;

            if (freq[first - 'a'] > 0) {
                pq.offer(first);
            }

            if (freq[second - 'a'] > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {
            char last = pq.poll();

            if (freq[last - 'a'] > 1) {
                return "";
            }

            sb.append(last);
        }

        return sb.toString();
    }
}