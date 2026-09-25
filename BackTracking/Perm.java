public class Perm {

    static void perm(String s, String current) {

        if (0 == s.length()) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            String newStr = s.substring(0, i) + s.substring(i + 1);
            perm(newStr, current + curr);
        }
    }

    public static void main(String[] args) {
        String s = "abc";

        perm(s, "");
    }
}