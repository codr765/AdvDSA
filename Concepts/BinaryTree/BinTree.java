//      1
//    /   \
//   2     6
//  / \   / \
// 3   4 7   8
//    /  / \ / \
//   5  9  10 11 12
//               /
//              13

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BinTree {
    static int idx = -1;

    static Node buildPreorder(int[] preOrder) {
        idx++;

        if (preOrder[idx] == -1) {
            return null;
        }

        Node node = new Node(preOrder[idx]);

        node.left = buildPreorder(preOrder);
        node.right = buildPreorder(preOrder);

        return node;
    }

    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);

        System.out.print(root.data + " ");

        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);

        System.out.print(root.data + " ");
    }

    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node curr = q.remove();

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            System.out.println();
        }
    }

    static int ctNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return ctNodes(root.left) + ctNodes(root.right) + 1;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    static int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = countLeafNodes(root.left);
        int right = countLeafNodes(root.right);

        return left + right;
    }

    static int countNonLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = countNonLeafNodes(root.left);
        int right = countNonLeafNodes(root.right);

        return 1 + left + right;
    }

    static int diameterBrute(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameterBrute(root.left);
        int rightDiameter = diameterBrute(root.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    static int diameterOptimized(Node root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return 0;
        }

        int[] leftHeight = new int[1];
        int[] rightHeight = new int[1];

        int leftDiameter = diameterOptimized(root.left, leftHeight);
        int rightDiameter = diameterOptimized(root.right, rightHeight);

        height[0] = 1 + Math.max(leftHeight[0], rightHeight[0]);

        int self = leftHeight[0] + rightHeight[0] + 1;

        return Math.max(self, Math.max(leftDiameter, rightDiameter));
    }

    static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.data != q.data) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static boolean isSubtree(Node root, Node subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static void topView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.add(new Pair(root, 0));

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            Node node = curr.node;
            int hd = curr.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            min = Math.min(min, hd);
            max = Math.max(max, hd);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        int[] preOrder = { 1, 2, 3, -1, -1, 4, 5, -1, -1, -1, 6, 7, 9, -1, -1, 10, -1, -1, 8, 11, -1, -1, 12, 13, -1,
                -1, -1 };

        Node root = buildPreorder(preOrder);

        // inOrderTraversal(root);
        // System.out.println();

        // preOrderTraversal(root);
        // System.out.println();

        // postOrderTraversal(root);
        // System.out.println();

        // levelOrderTraversal(root);
        // System.out.println();

        // System.out.println(ctNodes(root));
        // System.out.println(height(root));
        // System.out.println(sumOfNodes(root));
        // System.out.println(countLeafNodes(root));
        // System.out.println(countNonLeafNodes(root));
        // System.out.println(diameterBrute(root));
        // System.out.println(diameterOptimized(root, new int[1]));

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(3);
        // subRoot.right = new Node(4);

        // System.out.println(isSubtree(root, subRoot));

        topView(root);
    }
}