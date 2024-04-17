package StackImplementation;
import java.util.EmptyStackException;

public class Stack <T> {
    private T[] elems;
    private int top = 0;

    public Stack() {
        elems = (T[]) new Object[10];
    }

    public void push(T e) {
        if (top >= elems.length) {
            T[] copy = (T[]) new Object[elems.length*2];
            for(int i = 0; i != elems.length; ++i) {
                copy[i] = elems[i];
            }
            elems = copy;
        }
        elems[top++] = e;
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return elems[--top];
    }

    public T peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return elems[top-1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
