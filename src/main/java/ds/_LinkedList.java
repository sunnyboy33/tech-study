package ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class _LinkedList<E> implements Iterable<E>{

    private Node<E> head;
    private int pointer;

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public void add(E e) {
        Node<E> current = new Node<>(e); // data를 담은 노드 생성

        if (pointer == 0) {
            head = current; // 포인터가 0이라면, 현재 노드가 첫 노드
            pointer++;
            return;
        }

        Node<E> link = head; // 선택되는 다음 노드의 주소를 저장하는 variable (link)
        while (link.next()!= null) {
            link = link.next();
        }

        link.setNext(current);
        pointer++;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= pointer) throw new IndexOutOfBoundsException();
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> link = head;
        for (int i = 0; i < index; i++) { // 순회하면서 연결된 다음 노드로 넘어간다
            link = link.next();
        }
        return link.data(); // 해당 인덱스 노드의 값을 리턴
    }

    public void set(E e, int index) {
        checkIndex(index);
        Node<E> link = head;
        for (int i = 0; i < index; i++) {
            link = link.next();
        }
        link.setData(e);
    }

    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.next(); // 1번째 노드를 삭제하는 경우, 2번째 노드를 head에 이어준다.
            pointer--;
            return;
        }

        Node<E> link = head;
        Node<E> preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = link;
            link = link.next();
        }

        preNode.setNext(link.next()); // 이전 노드와 다음 노드를 연결
        pointer--;
    }

    public boolean contains(E e) {
        Node<E> link = head;
        while (link != null) { // 마지막 노드까지 순회
            if (link.data().equals(e)) {
                return true;
            }
            link = link.next();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            // iterable 익명 클래스
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
