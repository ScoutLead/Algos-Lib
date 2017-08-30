package list;
import static org.junit.jupiter.api.Assertions.assertEquals;

import list.implementation.Stack;
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

}
