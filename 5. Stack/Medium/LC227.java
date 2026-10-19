import java.util.Stack;

public class LC227 {
    static int calculate(String s) {
        Stack<Integer> stk = new Stack<>();

        int num = 0;
        char prevOp = '+';

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ')
                    || i == s.length() - 1) {

                if (prevOp == '+') {
                    stk.push(num);
                } else if (prevOp == '-') {
                    stk.push(-num);
                } else if (prevOp == '*') {
                    stk.push(stk.pop() * num);
                } else if (prevOp == '/') {
                    stk.push(stk.pop() / num);
                }

                num = 0;
                prevOp = c;
            }
        }

        int result = 0;

        while (!stk.isEmpty()) {
            result += stk.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "3+2*2";

        System.out.println(calculate(s));
    }
}
