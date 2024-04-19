package javafxintro;

import org.junit.jupiter.api.Test;

import StackImplementation.ArrayQueue;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ArrayQueueTest {
    @Test void initializeArrayQueue() {
        ArrayQueue<String> s = new ArrayQueue<String>();
        assertNotNull(s);
    }

    @Test void emptyNewArrayQueue() {
        ArrayQueue<String> s = new ArrayQueue<String>();
        assertEquals(true, s.isEmpty());
    }

    @Test void singlePeekElement() {
        ArrayQueue<String> s = new ArrayQueue<String>();
        s.enqueue("Hello");
        assertEquals("Hello", s.peek());
        assertEquals("Hello", s.peek());
    }

    @Test void singlePopElement() {
        
        ArrayQueue<String> s = new ArrayQueue<String>();
        s.enqueue("Hello");
        s.enqueue("Goodbye");
        assertEquals("Hello", s.dequeue());
        assertEquals("Goodbye", s.dequeue());
        
    }

    @Test void dequeueWrapping() {
        ArrayQueue<String> s = new ArrayQueue<String>();
        s.enqueue("Hello");
        s.enqueue("Goodbye");
        s.enqueue("A");
        s.enqueue("B");
        s.dequeue();
        s.dequeue();
        s.dequeue();
        s.dequeue();
        s.enqueue("A");
        s.enqueue("B");
        s.enqueue("C");
        s.enqueue("D");

        assertEquals(4,s.arraySize());
        assertEquals("A",s.dequeue());
        assertEquals("B",s.dequeue());
        assertEquals("C",s.dequeue());
        assertEquals("D",s.dequeue());
    }

    @Test void pushManyElements() {
        /*
        ArrayQueue<String> s = new ArrayQueue<String>();
        String[] words = {"First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth","Eleventh", 
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        for (String str : words) 
            s.push(str);

        for (int i = words.length-1; i >= 0 ; --i) {
            assertEquals(words[i], s.pop());
        }
        */
    }

    @Test void popEmptyArrayQueue() {
        /*
        ArrayQueue<String> s = new ArrayQueue<String>();
        assertThrows(EmptyArrayQueueException.class, () -> s.pop());
        assertThrows(EmptyArrayQueueException.class, () -> s.peek());
        */
    }
}
