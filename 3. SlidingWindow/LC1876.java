public class LC1876 {

    static int countGoodSubstrings(String s) {
        int count = 0;

        // for (int i = 0; i <= s.length() - 3; i++) {
        // int[] hash = new int[26];

        // for (int j = i; j < i + 3; j++) {
        // hash[s.charAt(j) - 'a']++;
        // }

        // int distinct = 0;

        // for (int j = 0; j < 26; j++) {
        // if (hash[j] == 1) {
        // distinct++;
        // }
        // }

        // if (distinct == 3) {
        // count++;
        // }
        // }

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i + 1) != s.charAt(i + 2) &&
                    s.charAt(i) != s.charAt(i + 2)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "xyzzaz";

        System.out.println(countGoodSubstrings(s));
    }
}
