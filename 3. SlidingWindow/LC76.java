public class LC76 {

    static String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;

        int[] hash = new int[256];
        int start = -1;
        int end = -1;

        int found = 0;

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            if (hash[s.charAt(right)] > 0) {
                found++;
            }

            hash[s.charAt(right)]--;

            while (found == t.length()) {

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                    end = right;
                }

                hash[s.charAt(left)]++;

                if (hash[s.charAt(left)] > 0) {
                    found--;
                }

                left++;
            }
        }

        return (start == -1) ? "" : s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}