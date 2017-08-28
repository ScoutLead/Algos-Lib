package list.implementation;

import list.IStack;
import list.implementation.LinkedList;

/**
 * Created by yurii.kachmar on 29.08.2017.
 */
public class Stack<T> implements IStack<T>{

    private T elements [];

    private int headIndex = 0;


    public Stack(T [] elements) {
        this.elements = elements;
    }


    public void push(T elem) {
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
        return elements[headIndex];
    }
}
