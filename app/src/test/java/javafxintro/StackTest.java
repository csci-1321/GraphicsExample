package javafxintro;

import org.junit.jupiter.api.Test;

import StackImplementation.Stack;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class StackTest {
    @Test void initializeStack() {
        Stack<String> s = new Stack<String>();
        assertNotNull(s);
    }

    @Test void emptyNewStack() {
        Stack<String> s = new Stack<String>();
        assertEquals(true, s.isEmpty());
    }

    @Test void singlePeekElement() {
        Stack<String> s = new Stack<String>();
        s.push("Hello");
        assertEquals("Hello", s.peek());
        assertEquals("Hello", s.peek());
    }

    @Test void singlePopElement() {
        Stack<String> s = new Stack<String>();
        s.push("Hello");
        s.push("Goodbye");
        assertEquals("Goodbye", s.pop());
        assertEquals("Hello", s.pop());
    }

    @Test void pushManyElements() {
        Stack<String> s = new Stack<String>();
        String[] words = {"First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth","Eleventh", 
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        for (String str : words) 
            s.push(str);

        for (int i = words.length-1; i >= 0 ; --i) {
            assertEquals(words[i], s.pop());
        }
    }

    @Test void popEmptyStack() {
        Stack<String> s = new Stack<String>();
        assertThrows(EmptyStackException.class, () -> s.pop());
        assertThrows(EmptyStackException.class, () -> s.peek());
    }
}
