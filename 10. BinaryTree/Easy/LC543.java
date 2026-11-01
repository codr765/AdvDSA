public class LC543 {
    int diameter = 0;

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        diameter = Math.max(diameter, lh + rh);

        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}

// class LC543 {
// static int height(TreeNode root) {
// if (root == null) {
// return 0;
// }

// return Math.max(height(root.left), height(root.right)) + 1;
// }

// public int diameterOfBinaryTree(TreeNode root) {
// if (root == null) {
// return 0;
// }

// return Math.max(height(root.left) + height(root.right),
// Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
// }
// }