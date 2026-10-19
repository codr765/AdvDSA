public class LC1047 {
    static String removeDuplicates(String s) {
        char[] stk = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (top >= 0 && stk[top] == curr) {
                top--;
            }

            else {
                stk[++top] = s.charAt(i);
            }
        }

        return new String(stk, 0, top + 1);
    }

    public static void main(String[] args) {
        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }
}
