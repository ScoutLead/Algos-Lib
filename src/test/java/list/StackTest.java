package list;
import static org.junit.jupiter.api.Assertions.assertEquals;

import list.implementation.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StackTest {

    @Test
    public void Push_SizeIsOne_IfAddOneElement() {
        //Arrange
        IStack<Integer> stack = new Stack<>(new Integer[4]);
        int expectedSize = 1;
        //Act
        stack.push(3);
        //Assert
        assertEquals(expectedSize, stack.size());
    }

    @Test
    public void Push_SizeIsLength_IfFullTheStack() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
        int expectedSize = arr.length;
        //Act
        for(int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        //Assert
        assertEquals(expectedSize, stack.size());
    }

    @Test
    public void Push_ThrowException_IfAddToFullTheStack() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
        String expectedExceptionMessage = "You can not push in full stack";
        //Act
        for(int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.push(1);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Peek_ThrowException_IfStackIsEmpty() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
        String expectedExceptionMessage = "You can not peek from empty stack";
        //Act
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Peek_HeadElement_IfAddOneElement() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
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
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
        int expectedValue = arr.length - 1;
        //Act
        for(int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        int actualValue = stack.peek();
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Pop_ThrowException_IfTheStackIsEmpty() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
        String expectedExceptionMessage = "You can not pop from empty stack";
        //Act
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Pop_SizeIsLengthMinusOne_IfTheStackIsFull() {
        //Arrange
        Integer [] arr = new Integer[4];
        IStack<Integer> stack = new Stack<>(arr);
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
        IStack<Integer> stack = new Stack<>(arr);
        int expectedSize = 0;
        //Act
        stack.push(1);
        stack.pop();
        //Assert
        assertEquals(expectedSize, stack.size());
    }

}
