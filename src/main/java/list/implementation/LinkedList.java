package list.implementation;

import list.IStack;

public class LinkedList<T> implements IStack<T> {
    private Node<T> first;
    private int size = 0;

    public void insert(int index, T value) {
        int currentIndex = 0;
        if(isEmpty()) {
            first = new Node<>(value, null);
            size ++;
        } else if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("You can not insert element after element with non-existent index " + index);
        } else {
            Node<T> parent = null;
            Node<T> current = first;

            if(index == 0) {
                Node<T> newValue = new Node<>(value, current);
                first = newValue;
            } else {
                while(current.hasNext()) {
                    if(index == currentIndex) {
                        Node<T> newValue = new Node<>(value, current);
                        current = newValue;
                        if(parent != null) {
                            parent.setNext(current);
                        }
                        break;
                    }
                    parent = current;
                    current = current.getNext();
                    currentIndex++;
                }

                if(index == size() - 1) {
                    parent.setNext(new Node<>(value, current));
                }
            }
            size ++;

        }

    }

    public void insertFirst(T value) {
        insert(0, value);
    }

    public void insertEnd(T value) {
        insert(size - 1, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void remove(int index) {
        int currentIndex = 0;
        if(isEmpty()) {
            throw new NullPointerException("List is empty. You cannot remove in empty list");
        } else if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("You can not remove element element with non-existent index " + index);
        } else {
            Node<T> parent = null;
            Node<T> current = first;
            if(currentIndex == index) {
                Node<T> next = current.getNext();
                first = next;
            } else {
                while(current.hasNext()) {
                    if(index == currentIndex) {
                        Node<T> next = current.getNext();
                        current = next;
                        if(parent != null) {
                            parent.setNext(current);
                        }
                        break;
                    }
                    parent = current;
                    current = current.getNext();

                    currentIndex++;
                }
            }

        }
        size --;

    }

    public T get(int index) {
        int currentIndex = 0;
        if(isEmpty()) {
            throw new NullPointerException("List is empty. You cannot get from empty list");
        } else if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("You can not get element with index " + index);
        } else {
            Node<T> current = first;
            while(current.hasNext()) {
                if(index == currentIndex) {
                    return current.getValue();
                }
                current = current.getNext();
                currentIndex++;
            }
            if(index == currentIndex) {
                return current.getValue();
            }
        }
        return null;
    }



    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public void push(T elem) {
        insertFirst(elem);
    }

    @Override
    public void pop() {
        removeFirst();
    }

    @Override
    public T peek() {
        return get(0);
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

}
