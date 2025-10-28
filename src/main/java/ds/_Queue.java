package ds;

public class _Queue<E> {

    private Node<E> top;
    private Node<E> tail;
    private int size;

    public int size() {return size;}

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(E e) {
        Node<E> node = new Node<>(e);
        if (top == null){ // 첫 번째 노드인 경우
            top = node;
            tail = node;
            size++;
            return;
        }
        tail.setNext(node);
        tail = node;
        size++;
    }

    public E poll() {
        if (top == null) return null;
        E data = top.data();
        top = top.next();
        size--;
        return data;
    }

    public E peek() {
        return (top == null) ? null : top.data();
    }

    public void clear() {
        top = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.data());
            if (current.next() != null) sb.append(", ");
            current = current.next();
        }
        return sb.append("]").toString();
    }
}
