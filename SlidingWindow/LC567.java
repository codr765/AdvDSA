public class LC567 {

    static boolean checkInclusion(String s1, String s2) {
        int size = s1.length();

        for (int i = 0; i <= s2.length() - size; i++) {

            int[] hash = new int[26];

            for (int j = i; j < i + size; j++) {
                hash[s2.charAt(j) - 'a']++;
            }

            for (int j = 0; j < s1.length(); j++) {

                hash[s1.charAt(j) - 'a']--;
            }

            boolean match = true;

            for (int j = 0; j < hash.length; j++) {
                if (hash[j] != 0) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
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