package javafxintro;

import org.junit.jupiter.api.Test;

import StackImplementation.ListQueue;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ListQueueTest {
    @Test void initializeListQueue() {
        ListQueue<String> s = new ListQueue<String>();
        assertNotNull(s);
    }

    @Test void emptyNewListQueue() {
        ListQueue<String> s = new ListQueue<String>();
        assertEquals(true, s.isEmpty());
    }

    @Test void singlePeekElement() {
        ListQueue<String> s = new ListQueue<String>();
        s.enqueue("Hello");
        assertEquals("Hello", s.peek());
        assertEquals("Hello", s.peek());
    }

    @Test void singlePopElement() {
        
        ListQueue<String> s = new ListQueue<String>();
        s.enqueue("Hello");
        s.enqueue("Goodbye");
        assertEquals("Hello", s.dequeue());
        assertEquals("Goodbye", s.dequeue());
        
    }

    @Test void dequeueWrapping() {
        ListQueue<String> s = new ListQueue<String>();
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

        //assertEquals(4,s.ListSize());
        assertEquals("A",s.dequeue());
        assertEquals("B",s.dequeue());
        assertEquals("C",s.dequeue());
        assertEquals("D",s.dequeue());
    }

    @Test void pushManyElements() {
        /*
        ListQueue<String> s = new ListQueue<String>();
        String[] words = {"First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth","Eleventh", 
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        for (String str : words) 
            s.push(str);

        for (int i = words.length-1; i >= 0 ; --i) {
            assertEquals(words[i], s.pop());
        }
        */
    }

    @Test void popEmptyListQueue() {
        /*
        ListQueue<String> s = new ListQueue<String>();
        assertThrows(EmptyListQueueException.class, () -> s.pop());
        assertThrows(EmptyListQueueException.class, () -> s.peek());
        */
    }
}
