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