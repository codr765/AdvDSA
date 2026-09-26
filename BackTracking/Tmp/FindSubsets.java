public class FindSubsets {

    static void subsets(String s, String curr, int idx) {

        if (idx == s.length()) {
            System.out.println(curr);
            return;
        }

        subsets(s, curr, idx + 1);

        subsets(s, curr + s.charAt(idx), idx + 1);
    }

    public static void main(String[] args) {

        String s = "abcd";

        subsets(s, "", 0);
    }
}