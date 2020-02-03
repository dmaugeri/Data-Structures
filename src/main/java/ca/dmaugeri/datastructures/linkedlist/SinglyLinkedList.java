package ca.dmaugeri.datastructures.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedList<T> implements LinkedList<T>, Iterable<T> {
    // The head is always an empty first node, that way we have an easy reference to the next
    // node, which is the actual 0 indexed node, and we don't need any special logic for the first node
    private SingleLinkedNode<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = new SingleLinkedNode<T>();
        this.size = 0;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // we want to get the previous node to change the pointer
        // if they add index 0 it will give us a reference to the head node, which is what we want so we can set the 0th node
        // which is head.getNext()
        var previousNode = getNode(index - 1);
        var newNode = new SingleLinkedNode<T>();
        newNode.setElement(element);
        newNode.setNext(previousNode.getNext());
        previousNode.setNext(newNode);
        size++;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addAll(int index, Collection<T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (c.size() == 0) {
            return;
        }

        var collectionIterator = c.iterator();
        var firstNode = new SingleLinkedNode<T>();
        firstNode.setElement(collectionIterator.next());

        var currentNewNode = firstNode;
        while (collectionIterator.hasNext()) {
            var newNode = new SingleLinkedNode<T>();
            newNode.setElement(collectionIterator.next());
            currentNewNode.setNext(newNode);
            currentNewNode = newNode;
        }

        var previousNode = getNode(index - 1);
        currentNewNode.setNext(previousNode.getNext());
        previousNode.setNext(firstNode);
        size += c.size();
    }

    @Override
    public void addAll(Collection<T> c) {
        addAll(size, c);
    }

    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    @Override
    public void addLast(T element) {
        add(size, element);
    }

    @Override
    public void clear() {
        var currentNode = head;
        while (currentNode != null) {
            var nextNode = currentNode.getNext();
            currentNode.setElement(null);
            currentNode.setNext(null);
            currentNode = nextNode;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getNode(index).getElement();
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public int indexOf(T t) {
        var currentNode = head;
        int index = 0;
        while (currentNode.hasNext()) {
            currentNode = currentNode.getNext();
            var element = currentNode.getElement();
            if (Objects.equals(element, t)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public T remove() {
        return remove(size - 1);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        var previousNode = getNode(index - 1);
        var nodeToBeDeleted = previousNode.getNext();
        previousNode.setNext(nodeToBeDeleted.getNext());
        var elementBeingDeleted = nodeToBeDeleted.getElement();
        nodeToBeDeleted.setNext(null);
        nodeToBeDeleted.setElement(null);
        size--;
        return elementBeingDeleted;
    }

    @Override
    public boolean remove(T e) {
        var current = head;
        while(current.hasNext()) {
            var nextNode = current.getNext();
            if (Objects.equals(e, nextNode.getElement())) {
                current.setNext(nextNode.getNext());
                nextNode.setNext(null);
                nextNode.setElement(null);
                size--;
                return true;
            }
            current = nextNode;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        var node = getNode(index);
        node.setElement(element);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private SingleLinkedNode<T> getNode(int index) {
        var current = head;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String toString() {
        var current = head.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (current != null) {
            stringBuilder.append(current.getElement().toString());
            current = current.getNext();
            if (current != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
