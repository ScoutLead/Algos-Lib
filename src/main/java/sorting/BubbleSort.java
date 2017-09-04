package sorting;

/**
 * Created by yurii.kachmar on 04.09.2017.
 */
public class BubbleSort {
    public static <T extends Comparable<T>> T []  sort (T [] array) {
        for(int i = 0; i < array.length - 1; i++) {
            boolean isSorting = true;
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j].compareTo(array[j + 1]) > 0) {
                    T el = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = el;
                    isSorting = false;
                }
            }
            if(isSorting) break;
        }
        return array;
    }
}
