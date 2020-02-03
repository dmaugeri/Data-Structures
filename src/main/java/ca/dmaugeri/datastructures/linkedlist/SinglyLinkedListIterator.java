package ca.dmaugeri.datastructures.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListIterator<T> implements Iterator<T> {
    private SinglyLinkedList<T> singlyLinkedList;

    public SinglyLinkedListIterator(SinglyLinkedList<T> singlyLinkedList) {
        this.singlyLinkedList = singlyLinkedList;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
