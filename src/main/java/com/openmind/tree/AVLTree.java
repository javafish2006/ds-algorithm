package com.openmind.tree;

class Node {

    int key;
    int height;
    Node left, right;

    public Node(int data) {
        key = data;
        height = 1;
    }
}

public class AVLTree {

    Node root;

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    //case: left-left
    Node rightRotate(Node root) {
        Node lNode = root.left;
        Node lrNode = lNode.right;

        root.left = lrNode;
        lNode.right = root;

        root.height = max(height(root.left), height(root.right)) + 1;
        lNode.height = max(height(lNode.left), height(lNode.right)) + 1;
        return lNode;
    }

    //case: right-right
    Node leftRorate(Node root) {
        Node rNode = root.right;
        root.right = rNode.left;
        rNode.left = root;
        //todo rNode height ; root height
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    //case: right -left
    Node rightLeftRotate(Node root) {
        root.right = rightRotate(root.right);
        root = leftRorate(root);
        return root;
    }

    //case: left - right
    Node leftRightRotate(Node root) {
        root.left = leftRorate(root.left);
        root = rightRotate(root);
        return root;
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        //perform the normal bst insertion
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        //update height of all ancestor of new inserted node recursively
        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);
        //case: left-left
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        //case: left -right
        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }

        //case: right-right
        if (balance < -1 && key > node.right.key) {
            return leftRorate(node);
        }

        //case: right -left
        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
//        /** 30
//         /  \
//         20   40
//         /  \   \
//         10  25   50
//         **/
//        AVLTree avl = new AVLTree();
//        avl.root = avl.insert(avl.root, 10);
//        avl.root = avl.insert(avl.root, 20);
//        avl.root = avl.insert(avl.root, 30);
//        avl.root = avl.insert(avl.root, 40);
//        avl.root = avl.insert(avl.root, 50);


        AVLTree avl = new AVLTree();
        avl.root = avl.insert(avl.root, 1);
        avl.root = avl.insert(avl.root, 4);
        avl.root = avl.insert(avl.root, 5);
        avl.root = avl.insert(avl.root, 6);
        avl.root = avl.insert(avl.root, 7);
        avl.root = avl.insert(avl.root, 10);
        avl.root = avl.insert(avl.root, 9);
        avl.root = avl.insert(avl.root, 8);
        avl.preOrder(avl.root);
    }
}
