import java.util.Stack;

public class LC316 {
    static String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        int[] freq = new int[26];
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;

            if (seen[ch - 'a']) {
                continue;
            }

            while (!stk.isEmpty() && stk.peek() > ch &&
                    freq[stk.peek() - 'a'] > 0) {
                seen[stk.pop() - 'a'] = false;
            }

            stk.push(ch);
            seen[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stk) {
            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";

        System.out.println(removeDuplicateLetters(s));
    }
}
