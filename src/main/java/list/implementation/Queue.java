package list.implementation;

import list.IQueue;

public class Queue<T> implements IQueue<T> {
    private T [] elements;
    private int headIndex;
    private int tailIndex;

    public Queue(T [] array) {
        this.elements = array;
        headIndex = tailIndex = elements.length;
    }
    @Override
    public T dequeue() {
        if(headIndex > tailIndex) {
            elements[--headIndex] = null;
            return elements[headIndex - 1];
        } else {
            throw new IndexOutOfBoundsException("You can not remove from empty queue");
        }
    }

    @Override
    public void enqueue(T elem) {
        if(tailIndex > 0) {
            elements[--tailIndex] = elem;
        } else {
            throw new IndexOutOfBoundsException("You can not push in full queue");
        }
    }

    @Override
    public T peek() {
        if(headIndex > tailIndex) {
            return elements[headIndex - 1];
        } else {
            throw new IndexOutOfBoundsException("You can not peek from empty queue");
        }
    }

    @Override
    public int size() {
        return headIndex - tailIndex;
    }
}
