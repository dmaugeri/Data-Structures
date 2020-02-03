package ca.dmaugeri.datastructures.linkedlist;

import java.util.Objects;

public class SingleLinkedNode<T> {
    private T element;
    private SingleLinkedNode<T> next;

    public SingleLinkedNode(T element, SingleLinkedNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public SingleLinkedNode() {
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SingleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLinkedNode<?> that = (SingleLinkedNode<?>) o;
        return Objects.equals(element, that.element) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, next);
    }
}
