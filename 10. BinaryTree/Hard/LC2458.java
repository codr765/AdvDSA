public class LC2458 {
    int[] height = new int[100001];
    int[] ans = new int[100001];

    public int[] treeQueries(TreeNode root, int[] queries) {
        findHeight(root);

        dfs(root, 0, 0);

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = ans[queries[i]];
        }

        return res;
    }

    int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        height[root.val] = 1 + Math.max(left, right);

        return height[root.val];
    }

    void dfs(TreeNode root, int depth, int maxHeight) {
        if (root == null) {
            return;
        }

        ans[root.val] = maxHeight;

        int leftHeight = height[root.left == null ? 0 : root.left.val];
        int rightHeight = height[root.right == null ? 0 : root.right.val];

        dfs(root.left, depth + 1,
                Math.max(maxHeight, depth + rightHeight));

        dfs(root.right, depth + 1,
                Math.max(maxHeight, depth + leftHeight));
    }
}
