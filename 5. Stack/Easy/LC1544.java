public class LC1544 {
    static String makeGood(String s) {
        char[] stk = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (top > -1 && Character.toLowerCase(curr) == Character.toLowerCase(stk[top]) && curr != stk[top]) {
                top--;
            } else {
                stk[++top] = curr;
            }
        }

        return new String(stk, 0, top + 1);
    }

    public static void main(String[] args) {
        String s = "leEeetcode";

        System.out.println(makeGood(s));
    }
}
