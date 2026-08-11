package solutions.week7.lesson19;

public class Lab1And3 {

    // Lab 1: Define the structure of a tree node
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        TreeNode root;

        // Lab 3: Count all nodes
        public int countNodes() {
            return countNodes(root);
        }

        private int countNodes(TreeNode node) {
            // Base case: an empty tree has 0 nodes
            if (node == null) {
                return 0;
            }

            return 1
                    + countNodes(node.left)
                    + countNodes(node.right);
        }

        // Lab 3: Count all leaf nodes
        public int countLeaves() {
            return countLeaves(root);
        }

        private int countLeaves(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // A leaf has no left or right child
            if (node.left == null && node.right == null) {
                return 1;
            }

            return countLeaves(node.left)
                    + countLeaves(node.right);
        }

        // Lab 3: Calculate the height of the tree
        // Height is measured by the number of edges.
        // An empty tree has height -1.
        // A tree with only one node has height 0.
        public int height() {
            return height(root);
        }

        private int height(TreeNode node) {
            if (node == null) {
                return -1;
            }

            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public static void main(String[] args) {

        // Lab 1: Build the binary tree manually
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(10);

        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(15);

        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(7);

        tree.root.right.right = new TreeNode(20);

        /*
                         10
                        /  \
                       5    15
                      / \     \
                     3   7     20
         */

        // Lab 3: Test the tree property methods
        System.out.println("Number of nodes: " + tree.countNodes());
        System.out.println("Number of leaves: " + tree.countLeaves());
        System.out.println("Height of tree: " + tree.height());
    }
}