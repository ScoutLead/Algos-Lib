package list;

public class LinkedList<T> {
    private Node<T> first;
    private int size = 0;

    public void insert(int index, T value) {
        int currentIndex = 0;
        if(isEmpty()) {
            first = new Node<>(value, null);
        } else if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> parent = null;
            Node<T> current = first;
            while(current.hasNext()) {
                if(index == currentIndex) {
                    Node<T> newValue = new Node<>(value, current);
                    current = newValue;
                    if(parent != null) {
                        parent.setNext(current);
                    }
                }
                parent = current;
                current = current.getNext();
                currentIndex++;
            }
        }
        size ++;

    }

    public void remove(int index) {
        int currentIndex = 0;
        if(isEmpty()) {
            throw new NullPointerException("List is empty. You cannot remove in empty list");
        } else if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> parent = null;
            Node<T> current = first;
            while(current.hasNext()) {
                if(index == currentIndex) {
                    Node<T> next = current.getNext();
                    current = next;
                    if(parent != null) {
                        parent.setNext(current);
                    }
                }
                parent = current;
                current = current.getNext();

                currentIndex++;
            }
        }
        size --;

    }



    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

}
