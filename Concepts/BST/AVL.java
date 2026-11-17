public class AVL {

    static class Node {
        int val, height;
        Node left, right;

        Node(int val) {
            this.val = val;
            height = 1;
        }
    }

    static Node root;

    // HEIGHT
    static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    // BALANCE FACTOR
    static int getBalance(Node root) {
        if (root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    // UPDATE HEIGHT
    static void updateHeight(Node root) {
        root.height = 1 + Math.max(
                height(root.left),
                height(root.right));
    }

    // RIGHT ROTATION
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // LEFT ROTATION
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // INSERTION
    static Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        updateHeight(root);

        int balance = getBalance(root);

        // LL CASE
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        // RR CASE
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // LR CASE
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL CASE
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // FIND MINIMUM
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // DELETION
    static Node delete(Node root, int val) {

        if (root == null)
            return null;

        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {

            // NO CHILD OR ONE CHILD
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // TWO CHILDREN
            Node temp = findMin(root.right);

            root.val = temp.val;

            root.right = delete(root.right, temp.val);
        }

        updateHeight(root);

        int balance = getBalance(root);

        // LL CASE
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // LR CASE
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR CASE
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // RL CASE
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // SEARCH
    static boolean search(Node root, int val) {
        if (root == null)
            return false;

        if (root.val == val)
            return true;

        if (val < root.val) {
            return search(root.left, val);
        }

        return search(root.right, val);
    }

    // INORDER
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // PREORDER
    static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // POSTORDER
    static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // FIND MAXIMUM
    static int findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.val;
    }

    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println("\nSearch 30: " + search(root, 30));

        System.out.println("Height: " + height(root));
        System.out.println("Balance Factor: " + getBalance(root));
        System.out.println("Maximum: " + findMax(root));

        root = delete(root, 40);

        System.out.print("After Deletion: ");
        inorder(root);
    }
}