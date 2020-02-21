package graph.bfs;

import java.util.NoSuchElementException;

/**
 * @author Sesh Venugopal
 */
public class Queue<T> {

    public static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> rear;
    private int size;

    public Queue() {
        rear = null;
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> newItem = new Node<T>(item, null);
        if (rear == null) {
            newItem.next = newItem;
        } else {
            newItem.next = rear.next;
            rear.next = newItem;
        }
        size++;
        rear = newItem;
    }

    public T dequeue()
            throws NoSuchElementException {
        if (rear == null) {
            throw new NoSuchElementException("queue is empty");
        }
        T data = rear.next.data;
        if (rear == rear.next) {
            rear = null;
        } else {
            rear.next = rear.next.next;
        }
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        rear = null;
    }

    public T peek()
            throws NoSuchElementException {
        if (rear == null) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.next.data;
    }
}