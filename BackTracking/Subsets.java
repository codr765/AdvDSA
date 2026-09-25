public class Subsets {
    static void subsets(String s, int idx) {
        if (s == "" || idx == s.length()) {
            System.out.println("");
            return;
        }

        System.out.println(s.charAt(idx));

        subsets(s.substring(idx, s.length()), idx + 1);
    }

    public static void main(String[] args) {
        String s = "abc";

        subsets(s, 0);
    }
}
