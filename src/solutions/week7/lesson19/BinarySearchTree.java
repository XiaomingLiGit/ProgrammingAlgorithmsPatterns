package solutions.week7.lesson19;

public class BinarySearchTree {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    private TreeNode root;

    // Lab 1: Search for a key
    public boolean search(int key) {
        TreeNode current = root;

        while (current != null) {
            if (key == current.key) {
                return true;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // Lab 1: Insert a key
    public void insert(int key) {
        TreeNode newNode = new TreeNode(key);

        // Empty tree
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;

            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                // Duplicate key
                System.out.println(
                        "Duplicate key " + key + " was ignored."
                );
                return;
            }
        }

        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    // Lab 1: Print the keys in sorted order
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    // Lab 2: Delete a key
    public void delete(int key) {
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode node, int key) {
        // Empty tree or key not found
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // The node has been found

            // Case 1 and Case 2:
            // No left child, so return the right child.
            // If the node is a leaf, the right child is null.
            if (node.left == null) {
                return node.right;
            }

            // Case 2: No right child
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            // Find the inorder successor
            TreeNode successor = findMinimum(node.right);

            // Replace the current key with the successor's key
            node.key = successor.key;

            // Delete the successor from the right subtree
            node.right = delete(node.right, successor.key);
        }

        return node;
    }

    private TreeNode findMinimum(TreeNode node) {
        TreeNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Verify that the tree still satisfies the BST property
    public boolean isValidBST() {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(
            TreeNode node, long minimum, long maximum) {

        if (node == null) {
            return true;
        }

        if (node.key <= minimum || node.key >= maximum) {
            return false;
        }

        return isValidBST(node.left, minimum, node.key)
                && isValidBST(node.right, node.key, maximum);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        int[] testData = {50, 30, 70, 20, 40, 60, 80};

        for (int key : testData) {
            tree.insert(key);
        }

        /*
                        50
                       /  \
                     30    70
                    / \    / \
                  20  40  60  80
         */

        System.out.print("Initial inorder: ");
        tree.inorder();

        System.out.println("search(60): " + tree.search(60));
        System.out.println("search(25): " + tree.search(25));

        // Test duplicate key
        tree.insert(60);

        // Case 1: Delete a leaf node
        System.out.println("\nDelete 20 (leaf node):");
        tree.delete(20);
        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST());

        // Case 2: Delete a node with one child
        System.out.println("\nDelete 30 (one child):");
        tree.delete(30);
        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST());

        // Case 3: Delete a node with two children
        System.out.println("\nDelete 50 (two children):");
        tree.delete(50);
        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST());
    }
}