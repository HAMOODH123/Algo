package com.excise;

import java.util.Random;
import static com.util.Print.*;
/**
 * 使用环形链表实现queue
 */
public class Queue {
    private Node last;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if(isEmpty()) {
            last = new Node(value);
            last.next = last;
        } else {
            Node first = last.next;
            last.next = new Node(value);
            last = last.next;
            last.next = first;
        }
        size++;
    }

    public int dequeue() {
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        int result = last.next.data;
        last.next = last.next.next;
        size--;
        return result;
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    @Override
    public String toString() {
        Node current = last.next;
        StringBuilder sb = new StringBuilder(current.data + "");
        for(int i = 0; i < size() - 1; i++) {
            current = current.next;
            sb.append(", " + current.data);
        }
        return "[" + sb.toString() + "]";
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Random r = new Random();
        for(int i = 0; i < 10; i++) {
            q.enqueue(r.nextInt(20));
        }
        println(q);
        q.dequeue();
        q.dequeue();
        println(q);
    }
}
