package com.openmind.tree;

class AVLNode {

    int key;
    int height;
    AVLNode left, right;

    public AVLNode(int key) {
        this.key = key;
    }
}

public class AVLTree {

    int height(AVLNode node){

        if (node == null) {
            return -1;
        }
        return node.height;
    }

    //
    AVLNode leftRorate(AVLNode root){
        AVLNode rNode = root.right;
        root.right = rNode.left;
        rNode.left = root;
        //todo rNode height ; root height
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }
}
