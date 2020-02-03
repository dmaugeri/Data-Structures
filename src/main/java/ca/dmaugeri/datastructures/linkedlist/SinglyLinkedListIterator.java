package ca.dmaugeri.datastructures.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SinglyLinkedListIterator<T> implements Iterator<T> {
    private SinglyLinkedList<T> singlyLinkedList;
    private int currentIndex;
    boolean hasCalledNext;

    public SinglyLinkedListIterator(SinglyLinkedList<T> singlyLinkedList) {
        this.singlyLinkedList = singlyLinkedList;
        this.currentIndex = -1;
        this.hasCalledNext = false;
    }

    @Override
    public void remove() {
        // Note: see the documentation for this function, the behaviour is not specified after a call to forEachRemaining
        if (!hasCalledNext) {
            throw new IllegalStateException("Must call next before remove");
        }
        singlyLinkedList.remove(currentIndex);
        currentIndex--;
        hasCalledNext = false;
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        while (hasNext()) {
            action.accept(next());
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < singlyLinkedList.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        currentIndex++;
        hasCalledNext = true;
        return singlyLinkedList.get(currentIndex);
    }
}
