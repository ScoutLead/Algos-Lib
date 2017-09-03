package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {
    @Test
    public void Sort_ArrayIsSorted_IntegerArray() {
        //Arrange
        Integer[] array = {4, 3, 2, 1};
        Integer[] expectedArray = {1, 2, 3, 4};
        //Act
        Integer[] actualArray =  SelectionSort.sort(array);
        //Assert
        assertArrayEquals(expectedArray, actualArray);
    }
}
