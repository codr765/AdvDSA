public class Subsets {

    static void subsets(String s, int index, String current) {

        if (index == s.length()) {
            System.out.println(current);
            return;
        }

        subsets(s, index + 1, current + s.charAt(index));

        subsets(s, index + 1, current);
    }

    public static void main(String[] args) {
        String s = "abc";

        subsets(s, 0, "");
    }
}