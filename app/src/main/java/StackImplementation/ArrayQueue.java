package StackImplementation;

public class ArrayQueue <T> {
    private T[] elems;
    private int head = 0, tail = 0, size = 0;

    public ArrayQueue() {
        elems = (T[]) new Object[10];
    }

    public void enqueue(T e) {
        // if full, resize
        if (size == elems.length) {
            T[] copy = (T[]) new Object[elems.length*2];
            for(int i = 0; i != elems.length; ++i) {
                copy[i] = elems[(head + i)%elems.length];
            }
            elems = copy;
        }
        elems[tail] = e;
        ++size;
        tail = (tail + 1) % elems.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
