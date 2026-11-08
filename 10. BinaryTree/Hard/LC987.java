import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC987 {
    List<int[]> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for (int[] arr : list) {
            int col = arr[0];
            int val = arr[2];

            if (col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = col;
            }

            ans.get(ans.size() - 1).add(val);
        }

        return ans;
    }

    void dfs(TreeNode root, int row, int col) {
        if (root == null)
            return;

        list.add(new int[] { col, row, root.val });

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}

// class Solution {
// public List<List<Integer>> verticalTraversal(TreeNode root) {

// List<int[]> list = new ArrayList<>();

// Queue<Object[]> q = new LinkedList<>();

// q.offer(new Object[]{root, 0, 0});

// while (!q.isEmpty()) {

// Object[] curr = q.poll();

// TreeNode node = (TreeNode) curr[0];
// int row = (int) curr[1];
// int col = (int) curr[2];

// list.add(new int[]{col, row, node.val});

// if (node.left != null) {
// q.offer(new Object[]{node.left, row + 1, col - 1});
// }

// if (node.right != null) {
// q.offer(new Object[]{node.right, row + 1, col + 1});
// }
// }

// Collections.sort(list, (a, b) -> {
// if (a[0] != b[0]) return a[0] - b[0];
// if (a[1] != b[1]) return a[1] - b[1];
// return a[2] - b[2];
// });

// List<List<Integer>> ans = new ArrayList<>();

// int prevCol = Integer.MIN_VALUE;

// for (int[] arr : list) {
// int col = arr[0];
// int val = arr[2];

// if (col != prevCol) {
// ans.add(new ArrayList<>());
// prevCol = col;
// }

// ans.get(ans.size() - 1).add(val);
// }

// return ans;
// }
// }
