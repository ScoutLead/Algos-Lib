package list;

import list.implementation.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    @Test
    public void Enqueue_SizeIsOne_IfAddOneElement() {
        //Arrange
        IQueue<Integer> queue = new Queue<>(new Integer[4]);
        int expectedSize = 1;
        //Act
        queue.enqueue(3);
        //Assert
        assertEquals(expectedSize, queue.size());
    }

    @Test
    public void Enqueue_SizeIsLength_IfFullThequeue() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        int expectedSize = arr.length;
        //Act
        for(int i = 0; i < arr.length; i++) {
            queue.enqueue(i);
        }
        //Assert
        assertEquals(expectedSize, queue.size());
    }

    @Test
    public void Enqueue_ThrowException_IfAddToFullThequeue() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        String expectedExceptionMessage = "You can not push in full queue";
        //Act
        for(int i = 0; i < arr.length; i++) {
            queue.enqueue(i);
        }
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.enqueue(1);
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Peek_ThrowException_IfqueueIsEmpty() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        String expectedExceptionMessage = "You can not peek from empty queue";
        //Act
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.peek();
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Peek_HeadElement_IfAddOneElement() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        int expectedValue = 4;
        //Act
        queue.enqueue(expectedValue);
        int actualValue = queue.peek();
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Peek_HeadElement_IfFullThequeue() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        int expectedValue = 0;
        //Act
        for(int i = 0; i < arr.length; i++) {
            queue.enqueue(i);
        }
        int actualValue = queue.peek();
        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Dequeue_ThrowException_IfTheQueueIsEmpty() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        String expectedExceptionMessage = "You can not remove from empty queue";
        //Act
        Throwable actualException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.dequeue();
        });
        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void Dequeue_SizeIsLengthMinusOne_IfThequeueIsFull() {
        //Arrange
        Integer [] arr = new Integer[5];
        IQueue<Integer> queue = new Queue<>(arr);
        int expectedSize = arr.length - 1;
        int expectedValue = 1;
        //Act
        for(int i = 0; i < arr.length; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        int actualValue = queue.peek();
        int actualSize = queue.size();
        //Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void Dequeue_SizeIsZero_IfThequeueHasOneElement() {
        //Arrange
        Integer [] arr = new Integer[4];
        IQueue<Integer> queue = new Queue<>(arr);
        int expectedSize = 0;
        //Act
        queue.enqueue(1);
        queue.dequeue();
        //Assert
        assertEquals(expectedSize, queue.size());
    }

}
