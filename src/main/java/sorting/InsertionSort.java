package sorting;

public class InsertionSort {
    public static <T extends Comparable<T>> T []  sort (T [] array) {
        for(int j = 1; j < array.length; j++) {
            T key = array[j];
            int i = j - 1;
            while(i > -1 && array[i].compareTo(key) > 0) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
        return array;
    }
}
