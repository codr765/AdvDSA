import java.util.Stack;

class LC32 {
    static int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stk.push(i);
            } else {
                stk.pop();

                if (stk.isEmpty()) {
                    stk.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stk.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()))"));
    }
}