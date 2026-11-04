import java.util.HashMap;

public class LC437 {
    // int ct = 0;

    // public int pathSum(TreeNode root, int targetSum) {
    // if (root == null) {
    // return 0;
    // }

    // find(root, targetSum);

    // pathSum(root.left, targetSum);
    // pathSum(root.right, targetSum);

    // return ct;
    // }

    // public void find(TreeNode root, long sum) {
    // if (root == null) {
    // return;
    // }

    // sum -= root.val;

    // if (sum == 0) {
    // ct++;
    // }

    // find(root.left, sum);
    // find(root.right, sum);
    // }

    int ct = 0;
    HashMap<Long, Integer> map = new HashMap<>();

    void find(TreeNode root, long targetSum, long currSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (map.containsKey(currSum - targetSum)) {
            ct += map.get(currSum - targetSum);
        }

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        find(root.left, targetSum, currSum);
        find(root.right, targetSum, currSum);

        map.put(currSum, map.get(currSum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0l, 1);

        find(root, targetSum, 0);

        return ct;
    }
}
