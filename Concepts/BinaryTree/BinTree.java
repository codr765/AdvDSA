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

    public static void main(String[] args) {
        int[] preOrder = { 1, 2, 3, -1, -1, 4, 5, -1, -1, -1, 6, 7, 9, -1, -1, 10, -1, -1, 8, 11, -1, -1, 12, 13, -1,
                -1,
                -1 };

        buildPreorder(preOrder);
    }
}