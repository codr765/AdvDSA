import java.util.ArrayList;
import java.util.List;

//              1
//            /   \
//          /       \
//        /           \
//       2             3
//    /     \       /     \
//   4       5     6       7
//  / \     / \   / \     / \
// 8   9   10 11 12  13  14  15

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC113 {
    static void find(TreeNode root, int targetSum, List<List<Integer>> list, List<Integer> tmp) {

        if (root == null) {
            return;
        }

        tmp.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                list.add(new ArrayList<>(tmp));
            }
        }

        find(root.left, targetSum, list, tmp);
        find(root.right, targetSum, list, tmp);

        tmp.remove(tmp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();

        find(root, targetSum, list, new ArrayList<>());

        return list;
    }

    static void allPaths(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left == null && root.right == null) {
            System.out.println(list);
        }

        allPaths(root.left, list);
        allPaths(root.right, list);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        allPaths(root, new ArrayList<>());
    }
}
