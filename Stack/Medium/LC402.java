import java.util.Stack;

public class LC402 {
    static String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char curr = num.charAt(i);

            while (!stk.isEmpty() && stk.peek() > curr && k > 0) {
                stk.pop();
                k--;
            }

            stk.push(curr);
        }

        while (!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }

        if (stk.isEmpty()) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stk) {
            if (ans.length() == 0 && ch == '0') {
                continue;
            }
            ans.append(ch);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }
}
