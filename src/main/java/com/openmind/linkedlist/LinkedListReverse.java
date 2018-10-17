package com.openmind.linkedlist;


class LinkedList {
    Node head;


    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    //insert as head
    void add(Node node) {
        if (node == null) {
            return;
        }

        node.next = head;
        head = node;
    }

    //reverse current element
    Node reverse(Node node) {
        Node current = node;
        Node pre = null, nextTmp;
        while (current != null) {
            //1.
            nextTmp = current.next;

            //2.
            current.next = pre;
            pre = current;
            current = nextTmp;
        }
        node = pre;
        return node;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(new Node(i));
        }

        System.out.print("origianl list: ");
        printList(list.head);

        System.out.printf("\nreversed list: ");
        list.head = list.reverse(list.head);
        printList(list.head);
    }
}

public class LinkedListReverse extends LinkedList {

    @Override
    Node reverse(Node node) {
        if (node == null || node.next == null) {
            //set the last element as the head of list
            head = node;
            return node;
        }

        Node headNode = reverse(node.next);
        headNode.next = node;
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();
        for (int i = 0; i < 21; i++) {
            list.add(new Node(i));
        }

        System.out.print("original list: ");
        printList(list.head);

        list.reverse(list.head);
        System.out.printf("\nreversed list: ");
        printList(list.head);

    }
}
