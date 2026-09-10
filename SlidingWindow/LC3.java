
public class LC3 {
    static int lengthOfLongestSubstring(String s) {
        int largest = 0;

        int[] lastSeen = new int[128];
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(left, lastSeen[s.charAt(right)]);

            largest = Math.max(largest, right - left + 1);

            lastSeen[s.charAt(right)] = right + 1;
        }

        return largest;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
