package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by yurii.kachmar on 04.09.2017.
 */
public class BubbleSortTest {
    @Test
    public void Sort_ArrayIsSorted_IntegerArray() {
        //Arrange
        Integer[] array = {5, 5, 4, 3, 2, 1};
        Integer[] expectedArray = {1, 2, 3, 4, 5, 5};
        //Act
        Integer[] actualArray =  BubbleSort.sort(array);
        //Assert
        assertArrayEquals(expectedArray, actualArray);
    }

}
