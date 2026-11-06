import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC863 {
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int tmp = 0;

        while (!q.isEmpty()) {
            if (tmp == k) {
                while (!q.isEmpty()) {
                    ans.add(q.remove().val);
                }
                break;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    q.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }

            tmp++;
        }

        return ans;
    }

    void findParent(TreeNode root, TreeNode par) {
        if (root == null) {
            return;
        }

        parent.put(root, par);

        findParent(root.left, root);
        findParent(root.right, root);
    }
}