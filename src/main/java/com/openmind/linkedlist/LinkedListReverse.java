package com.openmind.linkedlist;


class LinkedList {
    Node head;

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

    //Iterative reverse each node 就地反转
    static Node reverse(Node node) {
        Node current = node;
        Node pre = null, next;
        while (current != null) {
            //1.
            next = current.next;

            //2.
            current.next = pre;
            pre = current;
            current = next;
        }
        node = pre;
        return node;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList(new Node(1));
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        System.out.print("origianl list: ");
        printList(list.head);
        System.out.printf("\nreversed list: ");
        list.head = reverse(list.head);
        printList(list.head);
    }
}

public class LinkedListReverse {


    Node head;

    public LinkedListReverse(Node head) {
        this.head = head;
    }

    static class Node {
        int data;
        LinkedList.Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static void printList(LinkedList.Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    //recursively
    static Node reverse(Node node) {
        Node current = node;
        Node pre = null, next;
        while (current != null) {
            //1.
            next = current.next;

            //2.
            current.next = pre;
            pre = current;
            current = next;
        }
        node = pre;
        return node;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new LinkedList.Node(1));
        list.head.next = new LinkedList.Node(2);
        list.head.next.next = new LinkedList.Node(3);
        list.head.next.next.next = new LinkedList.Node(4);
        list.head.next.next.next.next = new LinkedList.Node(5);

        System.out.print("origianl list: ");
        printList(list.head);
        System.out.printf("\nreversed list: ");
        list.head = reverse(list.head);
        printList(list.head);
    }
}
