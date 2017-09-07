package list;

import list.implementation.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by yurii.kachmar on 07.09.2017.
 */
public class LinkedListTest {



    @Test
    public void Push_SizeIsOne_IfAddOneElement() {
        //Arrange
        IStack<Integer> stack = new LinkedList<>();
        int expectedSize = 1;
        //Act
        stack.push(3);
        //Assert
        assertEquals(expectedSize, stack.size());
    }

    @Test
    public void Push_SizeIsFour_IfFullTheStack() {
        //Arrange
        IStack<Integer> stack = new LinkedList<>();
        int expectedSize = 4;
        //Act
        for(int i = 0; i < expectedSize; i++) {
            stack.push(i);
        }
        //Assert
        assertEquals(expectedSize, stack.size());
    }


    @Test
    public void Peek_ThrowException_IfStackIsEmpty() {
        //Arrange
        IStack<Integer> stack = new LinkedList<>();
        String expectedExceptionMessage = "List is empty. You cannot get from empty list";
        //Act
        Throwable actualException = Assertions.assertThrows(NullPointerException.class, () -> {
            stack.peek();
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Peek_HeadElement_IfAddOneElement() {
        //Arrange
        IStack<Integer> stack = new LinkedList<>();
        int expectedValue = 4;
        //Act
        stack.push(expectedValue);
        int actualValue = stack.peek();
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Peek_HeadElement_IfFullTheStack() {
        //Arrange
        IStack<Integer> stack = new LinkedList<>();
        int [] arr = {1, 4, 3, 6, 2 } ;
        int expectedValue = 7;
        //Act
        for(int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        stack.push(expectedValue);
        int actualValue = stack.peek();
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Pop_ThrowException_IfTheStackIsEmpty() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new LinkedList<>();
        String expectedExceptionMessage = "List is empty. You cannot remove in empty list";
        //Act
        Throwable actualException = Assertions.assertThrows(NullPointerException.class, () -> {
            stack.pop();
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Pop_SizeIsLengthMinusOne_IfTheStackIsFull() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new LinkedList<>();
        int expectedSize = arr.length - 1;
        int expectedValue = arr.length - 2;
        //Act
        for(int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        stack.pop();
        int actualValue = stack.peek();
        int actualSize = stack.size();
        //Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Pop_SizeIsZero_IfTheStackHasOneElement() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new LinkedList<>();
        int expectedSize = 0;
        //Act
        stack.push(1);
        stack.pop();
        //Assert
        assertEquals(expectedSize, stack.size());
    }

    @Test
    public void GetSecondElement_IfSizeIsGreaterThanThree() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int [] arr = {1, 4, 5, 2, 3, 5};
        int expectedValue = arr[arr.length - 2];
        int index = 1;
        //Act
        for(int i = 0; i < arr.length; i ++) {
            list.push(arr[i]);
        }

        int actualValue = list.get(index);
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void GetLastElement_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int [] arr = {1, 4, 5, 2, 3, 5};
        int expectedValue = arr[0];
        //Act
        for(int i = 0; i < arr.length; i ++) {
            list.push(arr[i]);
        }

        int actualValue = list.get(list.size() - 1);
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void GetElementWithIndexLessThatZero_ThrowException_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int [] arr = {1, 4, 5, 2, 3, 5};
        int index = -2;
        String expectedExceptionMessage = "You can not get element with index " + index;
        //Act
        for(int i = 0; i < arr.length; i ++) {
            list.push(arr[i]);
        }

        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(index);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }
    @Test
    public void GetElementWithIndexGreaterThanSize_ThrowException_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int [] arr = {1, 4, 5, 2, 3, 5};
        int index = arr.length;
        String expectedExceptionMessage = "You can not get element with index " + index;
        //Act
        for(int i = 0; i < arr.length; i ++) {
            list.push(arr[i]);
        }

        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(index);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void InsertAfterSecondElement_SizeIsGreaterOnOne_IfSizeIsGreaterThanThree() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int expectedDifference = 1;
        int expectedValue = 33;
        int index = 2;
        int size = 4;
        //Act
        for(int i = 0; i < size; i++) {
            list.push(i);
        }
        int beforeSize = list.size();
        list.insert(index, expectedValue);
        int afterSize = list.size();

        int actualDifference = afterSize - beforeSize;
        int actualValue = list.get(index);
        //Assert
        assertEquals(expectedDifference, actualDifference);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void InsertLast_SizeIsGreaterOnOne_IfSizeIsGreaterThanThree() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int expectedDifference = 1;
        int expectedValue = 33;
        int size = 4;
        int index = size - 1;
        //Act
        for(int i = 0; i < size; i++) {
            list.push(i);
        }
        int beforeSize = list.size();
        list.insert(index, expectedValue);
        int afterSize = list.size();

        int actualDifference = afterSize - beforeSize;
        int actualValue = list.get(index);
        //Assert
        assertEquals(expectedDifference, actualDifference);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void InsertAfterElementWithIndexGreaterThanSize_ThrowException_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int size = 4;
        int index = size + 1;
        String expectedExceptionMessage = "You can not insert element after element with non-existent index " + index;
        //Act
        for(int i = 0; i < size; i++) {
            list.push(i);
        }
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(index, 4);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void InsertAfterElementWithIndexLessThanZero_ThrowException_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int size = 4;
        int index = -1;
        String expectedExceptionMessage = "You can not insert element after element with non-existent index " + index;
        //Act
        for(int i = 0; i < size; i++) {
            list.push(i);
        }
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(index, 4);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void RemoveElementWithIndexLessThanZero_ThrowException_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int size = 4;
        int index = -1;
        String expectedExceptionMessage = "You can not remove element element with non-existent index " + index;
        //Act
        for(int i = 0; i < size; i++) {
            list.push(i);
        }
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(index);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void RemoveElementWithIndexGreaterThanSize_ThrowException_IfSizeIsGreaterThanZero() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int size = 4;
        int index = size + 1;
        String expectedExceptionMessage = "You can not remove element element with non-existent index " + index;
        //Act
        for(int i = 0; i < size; i++) {
            list.push(i);
        }
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(index);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void RemoveLast_SizeIsLessOnOne_IfSizeIsGreaterThanThree() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int arr[] = {1, 4, 2, 6, 7};
        int index = arr.length - 1;
        int expectedDifference = -1;
        int expectedValue = arr[1];
        //Act
        for(int i = 0; i < arr.length; i++) {
            list.push(arr[i]);
        }
        int beforeSize = list.size();
        list.remove(index);
        int afterSize = list.size();

        int actualDifference = afterSize - beforeSize;
        int actualValue = list.get(index - 1);
        //Assert
        assertEquals(expectedDifference, actualDifference);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void RemoveSecond_SizeIsLessOnOne_IfSizeIsGreaterThanThree() {
        //Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int arr[] = {1, 4, 4, 3, 2, 6, 7};
        int index = 1;
        int expectedDifference = -1;
        int expectedValue = arr[arr.length - 3];
        //Act
        for(int i = 0; i < arr.length; i++) {
            list.push(arr[i]);
        }
        int beforeSize = list.size();
        list.remove(index);
        int afterSize = list.size();

        int actualDifference = afterSize - beforeSize;
        int actualValue = list.get(index);
        //Assert
        assertEquals(expectedDifference, actualDifference);
        assertEquals(expectedValue, actualValue);
    }


}
