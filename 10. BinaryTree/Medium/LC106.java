import java.util.HashMap;

public class LC106 {
    int idx;
    HashMap<Integer, Integer> map = new HashMap<>();

    TreeNode build(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[idx--]);

        int mid = map.get(root.val);

        root.right = build(postorder, mid + 1, end);
        root.left = build(postorder, start, mid - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = inorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }
}
