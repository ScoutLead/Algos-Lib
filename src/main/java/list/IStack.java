package list;

/**
 * Created by yurii.kachmar on 29.08.2017.
 */
public interface IStack<T> {

    void push(T elem);

    void pop();

    T peek();

    int size();
}
