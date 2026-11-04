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
        List<Integer> ans = new ArrayList<>();

        findParent(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (level == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                return ans;
            }

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

                TreeNode p = parent.get(curr);

                if (p != null && !visited.contains(p)) {
                    q.add(p);
                    visited.add(p);
                }
            }

            level++;
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