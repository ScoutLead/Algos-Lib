package list.implementation;

import list.IStack;
import list.implementation.LinkedList;

/**
 * Created by yurii.kachmar on 29.08.2017.
 */
public class Stack<T> implements IStack<T>{

    private T elements [];

    private int headIndex ;


    public Stack(T [] elements) {
        this.elements = elements;
        headIndex = elements.length;
    }


    public void push(T elem) {
        if(headIndex > 0) {
            elements[--headIndex] = elem;
        } else {
            throw new IndexOutOfBoundsException("You can not push in full stack");
        }
    }

    public void pop() {
        if(headIndex < elements.length) {
            elements[headIndex] = null;
            headIndex ++;
        } else {
            throw new IndexOutOfBoundsException("You can not pop from empty stack");
        }

    }

    public T peek() {
        if(headIndex < elements.length) {
            return elements[headIndex];
        } else {
            throw new IndexOutOfBoundsException("You can not peek from empty stack");
        }
    }

    @Override
    public int size() {
        return elements.length - headIndex;
    }
}
