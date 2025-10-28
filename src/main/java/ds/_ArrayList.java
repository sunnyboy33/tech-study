package ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class _ArrayList<E> implements Iterable<E> {

    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int pointer;

    public _ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public _ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        elementData = new Object[capacity];
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public int capacity() {
        return elementData.length;
    }

    public void resize(int newCapacity) {

        Object[] temp = new Object[newCapacity];
        for (int i = 0; i < pointer; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }

    public void ensureCapacity() {
        if (pointer == elementData.length) {
            resize(elementData.length * 2);
        }
    }

    public void add(E value) {
        ensureCapacity();
        elementData[pointer++] = value;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < pointer - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        pointer--;

        if (pointer > DEFAULT_CAPACITY && pointer < elementData.length / 2) {
            resize(Math.max(elementData.length / 2, DEFAULT_CAPACITY));
        }
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    public void set(int index, E value) {
        checkIndex(index);
        elementData[index] = value;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public void clear() {
        for (int i = 0; i < pointer; i++) elementData[i] = null;
        pointer = 0;
    }

    public boolean contains(E value) {
        for (int i = 0; i < pointer; i++) {
            if (elementData[i].equals(value)) return true;
        }
        return false;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int pointer;

            @Override
            public boolean hasNext() {
                return pointer < size();
            }

            @Override
            public E next() {
                if (pointer >= size()) throw new NoSuchElementException();
                E e = get(pointer);
                pointer++;
                return e;
            }
        };
    }
}
