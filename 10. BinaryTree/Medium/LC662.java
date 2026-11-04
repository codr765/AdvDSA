import java.util.LinkedList;
import java.util.Queue;

public class LC662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0L));

        long ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long min = q.peek().getValue();
            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> p = q.poll();

                TreeNode node = p.getKey();
                long idx = p.getValue() - min;

                if (i == 0)
                    first = idx;
                if (i == size - 1)
                    last = idx;

                if (node.left != null) {
                    q.add(new Pair<>(node.left, 2 * idx + 1));
                }

                if (node.right != null) {
                    q.add(new Pair<>(node.right, 2 * idx + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return (int) ans;
    }
}
