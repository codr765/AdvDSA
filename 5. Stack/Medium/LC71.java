import java.util.Stack;

public class LC71 {
    static String simplifyPath(String s) {
        Stack<String> stk = new Stack<>();

        String[] arr = s.split("/");

        for (String str : arr) {

            if (str.equals("") || str.equals(".")) {
                continue;
            }

            else if (str.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }

            else {
                stk.push(str);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String str : stk) {
            ans.append("/");
            ans.append(str);
        }

        if (ans.length() == 0) {
            return "/";
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";

        System.out.println(simplifyPath(path));
    }
}
