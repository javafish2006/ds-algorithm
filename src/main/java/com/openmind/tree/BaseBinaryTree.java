package com.openmind.tree;


public class BaseBinaryTree {

    Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }

    public BaseBinaryTree() {
        root = null;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    void levelOrderTraversal() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevelOrder(root, i);
        }
    }

    void printLevelOrder(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.println(root.data + " ");
            return;
        }

        if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        BaseBinaryTree bt = new BaseBinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        bt.levelOrderTraversal();
    }
}
