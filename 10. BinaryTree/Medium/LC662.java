import java.util.LinkedList;
import java.util.Queue;

public class LC662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Long> idx = new LinkedList<>();

        q.add(root);
        idx.add(0L);

        int width = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long min = idx.peek();
            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                long pos = idx.poll() - min;

                if (i == 0)
                    first = pos;
                if (i == size - 1)
                    last = pos;

                if (curr.left != null) {
                    q.add(curr.left);
                    idx.add(2 * pos);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    idx.add(2 * pos + 1);
                }
            }

            width = Math.max(width, (int) (last - first + 1));
        }

        return width;
    }
}