package ca.qc.vc.week7.lesson19;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTraversal {

    // =========================
    // Tree Node
    // =========================
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // ============================================================
    // 1. PREORDER: Root -> Left -> Right
    // ============================================================

    // Recursive
    public static void preorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    // Iterative
    public static void preorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.pop();

            // Visit root
            System.out.print(current.value + " ");

            // Push RIGHT first
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push LEFT second
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // ============================================================
    // 2. INORDER: Left -> Root -> Right
    // ============================================================

    // Recursive
    public static void inorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderRecursive(root.left);
        System.out.print(root.value + " ");
        inorderRecursive(root.right);
    }

    // Iterative
    public static void inorderIterative(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Go as far LEFT as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit node
            current = stack.pop();
            System.out.print(current.value + " ");

            // Move to RIGHT subtree
            current = current.right;
        }
    }

    // ============================================================
    // 3. POSTORDER: Left -> Right -> Root
    // ============================================================

    // Recursive
    public static void postorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.value + " ");
    }

    // Iterative -- Two Stacks
    public static void postorderIterative(TreeNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            TreeNode current = stack1.pop();

            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // Reverse order
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }


    // ============================================================
    // 4. BREADTH-FIRST / LEVEL-ORDER
    // ============================================================

    public static void breadthFirstTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Remove the node at the front
            TreeNode current = queue.poll();

            // Visit
            System.out.print(current.value + " ");

            // Add children to the queue
            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }


    // ============================================================
    // Main
    // ============================================================

    public static void main(String[] args) {

        /*
                    60
                  /    \
                55      100
               /  \     /  \
             45   57   67  107
                    \      /
                    59    101
         */

        TreeNode root = new TreeNode(60);

        root.left = new TreeNode(55);
        root.right = new TreeNode(100);

        root.left.left = new TreeNode(45);
        root.left.right = new TreeNode(57);

        root.left.right.right = new TreeNode(59);

        root.right.left = new TreeNode(67);
        root.right.right = new TreeNode(107);

        root.right.right.left = new TreeNode(101);


        // =========================
        // Preorder
        // =========================
        System.out.println("Preorder Recursive:");
        preorderRecursive(root);

        System.out.println("\n\nPreorder Iterative:");
        preorderIterative(root);


        // =========================
        // Inorder
        // =========================
        System.out.println("\n\nInorder Recursive:");
        inorderRecursive(root);

        System.out.println("\n\nInorder Iterative:");
        inorderIterative(root);


        // =========================
        // Postorder
        // =========================
        System.out.println("\n\nPostorder Recursive:");
        postorderRecursive(root);

        System.out.println("\n\nPostorder Iterative:");
        postorderIterative(root);

        System.out.println();
    }
}