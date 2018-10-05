package com.openmind.tree;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            this.key = item;
            left = right = null;
        }
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

    void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }

        //visit node
        System.out.print(node.key + "  ");

        //traverse left-subtree
        traversePreOrder(node.left);

        //traverse right-substree
        traversePreOrder(node.right);
    }

    void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }

        //traverse left-subtree
        traversePostOrder(node.left);


        //traverse right-substree
        traversePostOrder(node.right);

        //visit node
        System.out.print(node.key + "  ");
    }


    void traverseLevelOrder(Node node, int level) {
        System.out.printf("\n node: %s , level: %s ------ ", node == null ? "" : node.key, level);
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.key + "  ");
            return;
        }

        traverseLevelOrder(node.left, level - 1);
        traverseLevelOrder(node.right, level - 1);
    }

    void traverseInOrder() {
        traverseInOrder(root);
    }

    void traversePreOrder() {
        traversePreOrder(root);
    }

    void traversePostOrder() {
        traversePostOrder(root);
    }

    void traverseLevelOrder() {

        int h = height(root);
        for (int i = 1; i <= h; i++) {
            System.out.println("--------i start " + i);
            traverseLevelOrder(root, i);
            System.out.printf("\n--------%s end \n", i);
        }
    }

    void traverseLevelOrderByArray() {
        ArrayList<Node> array = new ArrayList<>();
        array.add(root);

        while (!array.isEmpty()) {
            ArrayList<Node> tmp = new ArrayList<>();
            for (Node t : array) {
                //1.visit the node
                System.out.print(t.key + " ");

                //2.
                if (t.left != null) {
                    tmp.add(t.left);
                }

                if(t.right != null){
                    tmp.add(t.right);
                }
            }

            array = tmp;
        }
    }


    void traverseLevelOrderByDequeue(){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            Node poll = deque.poll();
            //1.visit
            System.out.print(poll.key + " ");

            //2.level add
            if(poll.left != null){
                deque.offer(poll.left);
            }

            if(poll.right != null){
                deque.offer(poll.right);
            }
        }
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return (lh > rh ? lh : rh) + 1;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        System.out.println("traverse in order ");
        binaryTree.traverseInOrder();
        System.out.println();
        System.out.println("traverse pre order ");
        binaryTree.traversePreOrder();
        System.out.println();
        System.out.println("traverse post order ");
        binaryTree.traversePostOrder();
        System.out.println();
        System.out.println("----------------------------------------------------");

        System.out.println("traverse level order");
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);
        binaryTree.traverseLevelOrder();
        System.out.println();
        binaryTree.traverseLevelOrderByArray();
        System.out.println();
        binaryTree.traverseLevelOrderByDequeue();
    }
}

public class BinaryTreeTraverse {

    //todo 非递归方式遍历
}
