import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class BST {

    static Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    static Node buildBST(int[] nodes) {

        Node root = null;

        for (int val : nodes) {
            root = insert(root, val);
        }

        return root;
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        System.out.print(root.data + " ");

        inOrder(root.right);
    }

    static boolean isPresent(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return isPresent(root.left, key);
        } else {
            return isPresent(root.right, key);
        }
    }

    static Node delete(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.data = successor.data;

            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    static void printInRange(Node root, int k1, int k2) {

        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    static void printPaths(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            printPaths(root.left, path);
            printPaths(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    static boolean isValid(Node root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }

    static Node mirror(Node root) {

        if (root == null) {
            return null;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);

        return root;
    }

    public static void main(String[] args) {

        int[] nodes = { 5, 1, 3, 4, 2, 7 };

        Node root = buildBST(nodes);

        // System.out.println(isValid(root, Long.MIN_VALUE, Long.MAX_VALUE));

        // Node mirrored = mirror(root);
    }
}