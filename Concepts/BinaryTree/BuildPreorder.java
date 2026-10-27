class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class BuildPreorder {

    static int idx = -1;

    static Node buildTree(int[] nodes) {
        idx++;

        if (nodes[idx] == -1) {
            return null;
        }

        Node node = new Node(nodes[idx]);

        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int ctNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return ctNodes(root.left) + ctNodes(root.right) + 1;
    }

    static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        return sum(root.left) + sum(root.right) + root.val;
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = buildTree(nodes);

        preOrder(root);
    }
}