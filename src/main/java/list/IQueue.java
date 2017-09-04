package list;

public interface IQueue<T> {
    T dequeue();
    void enqueue(T elem);
    T peek();
    int size();

}
