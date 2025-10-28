package ds;

public class _Stack<E> {

    private Node<E> top; // LinkedList 처럼 top 으로 연결
    private int size;

    public int size() {return size;}

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        Node<E> node = new Node<>(e);
        if (top != null) {
            node.setNext(top);
        }
        top = node;
        size++;
    }

    public E pop(){
        if (top == null) return null;
        E data = top.data(); // 데이터 저장
        top = top.next(); // 다음 노드로 교체
        size--;
        return data;
    }

    public E peek(){
        return (top == null) ? null : top.data();
    }

    public void clear() {
        top = null; // 상단 노드 연결만 끊으면 됨
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
