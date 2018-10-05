package com.openmind.leetcode;


class LinkedList {

    Node head;

    static class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    //recursion
    Node reverseRecursively(Node curr, Node prev) {

        //visit the last, marked it head
        if (curr.next == null) {
            head = curr;
            curr.next = prev;

            return null;
        }

        Node next1 = curr.next;
        curr.next = prev;

        reverseRecursively(next1, curr);
        return head;
    }

    //iterator
    Node reverseIteratively(Node node){

        Node prev = null, next = null, curr = node;
        while(curr != null){
            next = curr.next; //tmp

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }


    void print(){
        print(head);
    }

    void print(Node node) {
        while (node != null) {
            System.out.print(node.key + " ");
            node = node.next;
        }
    }
}

public class LinkedListReverse {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new LinkedList.Node(1);
        linkedList.head.next = new LinkedList.Node(2);
        linkedList.head.next.next = new LinkedList.Node(3);
        linkedList.head.next.next.next = new LinkedList.Node(4);
        linkedList.head.next.next.next.next = new LinkedList.Node(5);
        linkedList.head.next.next.next.next.next = new LinkedList.Node(6);

        linkedList.print();

        linkedList.reverseRecursively(linkedList.head, null);

        System.out.println();
        linkedList.print();

        System.out.println();
        linkedList.reverseIteratively(linkedList.head);
        linkedList.print();

    }
}
