package StackImplementation;

public class ListQueue <T> {
    private int size;
    private Node<T> head, tail;
    
    @SuppressWarnings("unchecked")
    public ListQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    @SuppressWarnings("unchecked")
    public void enqueue(T e) {
        if (tail == null) {
            Node<T> newNode = new Node<T>(e, null,null);
            head = newNode;
            tail = newNode;
        } else {
            Node<T> newNode = new Node<T>(e, tail,null);
            tail.next = newNode;
            tail = newNode;
        }

        ++size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        return head.data;
    }

    public T dequeue() {
        Node<T> oldNode = head;
        head = head.next;
        --size;
        if (size == 0) {
            tail = null;
        } else {
            head.prev = null;
        }
        return oldNode.data;
    }

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
