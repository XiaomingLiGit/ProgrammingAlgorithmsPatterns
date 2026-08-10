package ca.qc.vc.week7.lesson19;

public class BinarySearchTree<E extends Comparable<? super E>> {

    // =========================================================
    // Tree Node
    // =========================================================
    public static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
        }
    }

    private TreeNode<E> root;


    // =========================================================
    // Insert
    // =========================================================
    public boolean insert(E element) {

        if (root == null) {
            root = new TreeNode<>(element);
            return true;
        }

        TreeNode<E> current = root;
        TreeNode<E> parent = null;

        while (current != null) {

            parent = current;

            int comparison = element.compareTo(current.element);

            if (comparison < 0) {
                current = current.left;
            }
            else if (comparison > 0) {
                current = current.right;
            }
            else {
                // Duplicate value
                return false;
            }
        }

        if (element.compareTo(parent.element) < 0) {
            parent.left = new TreeNode<>(element);
        }
        else {
            parent.right = new TreeNode<>(element);
        }

        return true;
    }


    // =========================================================
    // Search - Iterative
    // =========================================================
    public boolean searchIterative(E element) {

        TreeNode<E> current = root;

        while (current != null) {

            int comparison = element.compareTo(current.element);

            if (comparison < 0) {
                // Search left subtree
                current = current.left;
            }
            else if (comparison > 0) {
                // Search right subtree
                current = current.right;
            }
            else {
                // Found
                return true;
            }
        }

        return false;
    }


    // =========================================================
    // Search - Recursive
    // =========================================================
    public boolean searchRecursive(E element) {

        return searchRecursive(root, element);
    }


    private boolean searchRecursive(TreeNode<E> current, E element) {

        // Base case 1:
        // Reached an empty subtree
        if (current == null) {
            return false;
        }

        int comparison = element.compareTo(current.element);

        // Base case 2:
        // Element found
        if (comparison == 0) {
            return true;
        }

        // Recursive case:
        // Search left subtree
        if (comparison < 0) {
            return searchRecursive(current.left, element);
        }

        // Recursive case:
        // Search right subtree
        return searchRecursive(current.right, element);
    }


    // =========================================================
    // Inorder Traversal
    // Used here only to verify the BST
    // =========================================================
    public void inorder() {
        inorder(root);
        System.out.println();
    }


    private void inorder(TreeNode<E> node) {

        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.element + " ");
        inorder(node.right);
    }


    // =========================================================
    // Main
    // =========================================================
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree =
                new BinarySearchTree<>();

        // Construct BST
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);
        tree.insert(59);
        tree.insert(101);

        /*
                    60
                  /    \
                55      100
               /  \     /  \
             45   57   67   107
                    \        /
                    59      101
         */

        System.out.println("Inorder:");
        tree.inorder();

        System.out.println();

        // Iterative search
        System.out.println("Iterative Search:");

        System.out.println(
                "Search 59: " +
                        tree.searchIterative(59)
        );

        System.out.println(
                "Search 80: " +
                        tree.searchIterative(80)
        );


        System.out.println();

        // Recursive search
        System.out.println("Recursive Search:");

        System.out.println(
                "Search 59: " +
                        tree.searchRecursive(59)
        );

        System.out.println(
                "Search 80: " +
                        tree.searchRecursive(80)
        );
    }
}