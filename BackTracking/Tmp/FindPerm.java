public class FindPerm {

    static void perm(String s, String curr) {

        if (0 == s.length()) {
            System.out.println(curr);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            perm((s.substring(0, i) + s.substring(i + 1)), curr + s.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s = "abcd";

        perm(s, "");
    }
}
