public class LC567 {

    static boolean checkInclusion(String s1, String s2) {
        // int size = s1.length();

        // for (int i = 0; i <= s2.length() - size; i++) {

        // int[] hash = new int[26];

        // for (int j = i; j < i + size; j++) {
        // hash[s2.charAt(j) - 'a']++;
        // }

        // for (int j = 0; j < s1.length(); j++) {

        // hash[s1.charAt(j) - 'a']--;
        // }

        // boolean match = true;

        // for (int j = 0; j < hash.length; j++) {
        // if (hash[j] != 0) {
        // match = false;
        // break;
        // }
        // }

        // if (match) {
        // return true;
        // }

        // }

        // return false;

        int[] hash = new int[26];
        int[] hash2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            hash2[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            hash[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                hash[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (i >= s1.length() - 1) {
                boolean matched = true;

                for (int j = 0; j < 26; j++) {
                    if (hash[j] != hash2[j]) {
                        matched = false;
                        break;
                    }
                }

                if (matched) {
                    return true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}