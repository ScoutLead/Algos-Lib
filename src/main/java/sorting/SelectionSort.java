package sorting;

public class SelectionSort {
    public static <T extends Comparable<T>> T []  sort (T [] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for(int y = i + 1; y < array.length; y ++) {
                if(array[minIndex].compareTo(array[y]) > 0) {
                    minIndex = y;
                }
            }
            T min = array[minIndex];
            array[minIndex] = array[i];
            array[i] = min;
        }
        return array;
    }
}
