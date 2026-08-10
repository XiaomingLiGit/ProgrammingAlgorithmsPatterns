package ca.qc.vc.week7.lesson19;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCode {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter a text: ");
            String text = input.nextLine();

            if (text.isEmpty()) {
                System.out.println("The text cannot be empty.");
                return;
            }

            // Count character frequencies
            int[] counts = getCharacterFrequency(text);

            // Build Huffman tree
            Tree tree = getHuffmanTree(counts);

            if (tree == null) {
                System.out.println("No Huffman tree can be created.");
                return;
            }

            // Generate Huffman codes
            String[] codes = getCode(tree.root);

            System.out.printf(
                    "%-15s%-15s%-15s%-15s%n",
                    "ASCII Code",
                    "Character",
                    "Frequency",
                    "Code"
            );

            for (int i = 0; i < codes.length; i++) {

                if (counts[i] != 0) {

                    System.out.printf(
                            "%-15d%-15s%-15d%-15s%n",
                            i,
                            (char) i,
                            counts[i],
                            codes[i]
                    );
                }
            }
        }
    }


    // =========================================================
    // Generate Huffman Codes
    // =========================================================

    /**
     * Get Huffman codes for all characters.
     */
    public static String[] getCode(Tree.Node root) {

        if (root == null) {
            return null;
        }

        String[] codes = new String[128];

        // Special case:
        // only one different character in the input
        if (root.left == null && root.right == null) {
            codes[root.element] = "0";
            return codes;
        }

        assignCode(root, "", codes);

        return codes;
    }


    /**
     * Recursively assign codes to leaf nodes.
     */
    private static void assignCode(
            Tree.Node node,
            String code,
            String[] codes) {

        if (node == null) {
            return;
        }

        // Leaf node
        if (node.left == null && node.right == null) {

            codes[node.element] = code;
            return;
        }

        // Left edge = 0
        assignCode(node.left, code + "0", codes);

        // Right edge = 1
        assignCode(node.right, code + "1", codes);
    }


    // =========================================================
    // Build Huffman Tree
    // =========================================================

    /**
     * Build a Huffman tree from character frequencies.
     */
    public static Tree getHuffmanTree(int[] counts) {

        // Java built-in min-priority queue
        PriorityQueue<Tree> queue = new PriorityQueue<>();

        // Create one tree for each character
        for (int i = 0; i < counts.length; i++) {

            if (counts[i] > 0) {

                queue.offer(
                        new Tree(counts[i], (char) i)
                );
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        // Repeatedly combine the two smallest trees
        while (queue.size() > 1) {

            Tree t1 = queue.poll();
            Tree t2 = queue.poll();

            Tree combinedTree = new Tree(t1, t2);

            queue.offer(combinedTree);
        }

        // Final Huffman tree
        return queue.poll();
    }


    // =========================================================
    // Character Frequency
    // =========================================================

    /**
     * Count frequency of ASCII characters.
     */
    public static int[] getCharacterFrequency(String text) {

        int[] counts = new int[128];

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch < 128) {
                counts[ch]++;
            } else {
                System.out.println(
                        "Warning: non-ASCII character ignored: " + ch
                );
            }
        }

        return counts;
    }


    // =========================================================
    // Huffman Tree
    // =========================================================

    public static class Tree implements Comparable<Tree> {

        Node root;


        /**
         * Create an internal node by combining two trees.
         */
        public Tree(Tree t1, Tree t2) {

            root = new Node();

            root.left = t1.root;
            root.right = t2.root;

            root.weight =
                    t1.root.weight +
                            t2.root.weight;
        }


        /**
         * Create a tree containing one leaf node.
         */
        public Tree(int weight, char element) {

            root = new Node(weight, element);
        }


        /**
         * Compare trees based on weight.
         *
         * PriorityQueue removes the smallest one first.
         */
        @Override
        public int compareTo(Tree other) {

            return Integer.compare(
                    this.root.weight,
                    other.root.weight
            );
        }


        // =====================================================
        // Tree Node
        // =====================================================

        public static class Node {

            char element;
            int weight;

            Node left;
            Node right;


            /**
             * Create an internal node.
             */
            public Node() {
            }


            /**
             * Create a leaf node.
             */
            public Node(int weight, char element) {

                this.weight = weight;
                this.element = element;
            }
        }
    }
}