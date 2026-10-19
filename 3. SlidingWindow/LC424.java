public class LC424 {

    static int characterReplacement(String s, int k) {
        int ans = 0;

        int maxFreq = 0;

        int[] hash = new int[26];

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            hash[curr - 'A']++;

            maxFreq = Math.max(maxFreq, hash[curr - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
