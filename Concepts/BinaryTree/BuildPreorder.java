class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

class Info {
    int height;
    int diameter;

    Info(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
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

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currentDiameter = leftHeight + rightHeight + 1;

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    static Info diameterOptimized(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOptimized(root.left);
        Info rightInfo = diameterOptimized(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                leftInfo.height + rightInfo.height + 1);

        return new Info(height, diameter);
    }

    public static void main(String[] args) {

        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = buildTree(nodes);

        preOrder(root);
    }
}