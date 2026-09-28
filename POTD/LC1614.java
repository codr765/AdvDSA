class LC1614 {
    static int maxDepth(String s) {
        int depth = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                ans = Math.max(ans, depth);
            } else if (c == ')') {
                depth--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s));
    }
}