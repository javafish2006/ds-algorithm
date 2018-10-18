package com.openmind.tree;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            this.key = item;
            left = right = null;
        }
    }

    void insert(int key) {
        root = insert(root, key);
    }

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }


        //less
        if (key < root.key) {
            root.left = insert(root.left, key);
        }

        //greater
        if (key > root.key) {
            root.right = insert(root.right, key);
        }

        //equal
        return root;
    }

    Node search(Node root, int key) {
        if (root == null || key == root.key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    void delete(int key) {
        delete(root, key);
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

            //node matched , with no child or one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //node matched, with two child
            root.key = minValue(root.right);

            root.right = delete(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;

        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


    void traverseInOrder() {
        traverseInOrder(root);
    }

    void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        //traverse left-subtree
        traverseInOrder(node.left);

        //visit node
        System.out.print(node.key + "  ");

        //traverse right-substree
        traverseInOrder(node.right);

    }

    public static void main(String[] args) {
        /* BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(70);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
//        binarySearchTree.insert(60);
        binarySearchTree.insert(80);

        binarySearchTree.traverseInOrder();
        System.out.println();

        Node search = binarySearchTree.search(binarySearchTree.root, 40);
        System.out.println(search.key);

//        binarySearchTree.delete(50);
        binarySearchTree.delete(70);
        System.out.println();
    }

}
