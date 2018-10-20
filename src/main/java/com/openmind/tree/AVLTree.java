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

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        return current;
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

    Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                Node tmp = root.left != null ? root.left : root.right;
                if (tmp != null) {
                    //case: one child
                    root = tmp;
                } else {
                    //case: no child
                    tmp = root;
                    root = null;
                }
            } else {
                //case: two child
                Node tmp = minValueNode(root.right);
                root.key = tmp.key;
                //remove the min value node  of right-subtree
                root.right = delete(root.right, tmp.key);
            }

        }

        if (root == null) {
            return root;
        }


        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        //case : left - left
        if (balance > 1 && (getBalance(root.left) > 0)) {
            return rightLeftRotate(root);
        }

        //case: left -right
        if (balance > 1 && (getBalance(root.left) < 0)) {
            return leftRightRotate(root);
        }

        //case: right -left
        if (balance < -1 && getBalance(root.right) > 0) {
            return rightLeftRotate(root);
        }

        //case: right -right
        if (balance < -1 && getBalance(root.right) < 0) {
            return leftRorate(root);
        }

        return root;
    }


    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
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

        //      6
        //     /  \
        //   4     9
        //  /  \  /  \
        //  1  5  7  10
        //         \
        //          8
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
        System.out.println();
//        avl.inOrder(avl.root);
//        System.out.println();
//        avl.postOrder(avl.root);

//        avl.delete(avl.root, 8);
//        avl.delete(avl.root, 7);
        avl.delete(avl.root, 6);
        avl.preOrder(avl.root);
    }
}
