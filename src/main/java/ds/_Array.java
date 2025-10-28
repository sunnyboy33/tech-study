package ds;

public class _Array {

    private int[] data;
    private int size;

    public _Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int value) {
        if (size == data.length) {
            throw new RuntimeException("Array is fulled.");
        }
        data[size++] = value;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.println("]");
        }
    }
}
