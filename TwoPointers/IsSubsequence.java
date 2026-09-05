public class IsSubsequence {
    static boolean isSubsequence(String s, String t) {

        // int slow = 0;

        // for (int fast = 0; fast < t.length(); fast++) {

        // if (s.charAt(slow) == t.charAt(fast)) {
        // slow++;
        // }

        // if (slow == s.length()) {
        // return true;
        // }
        // }

        // return slow == s.length();

        int i = 0;

        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
}
