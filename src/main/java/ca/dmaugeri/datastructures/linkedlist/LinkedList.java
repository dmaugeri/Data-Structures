package ca.dmaugeri.datastructures.linkedlist;

import java.util.Collection;

public interface LinkedList<T> {
    /**
     * This method inserts the specified element at the position in this list
     * @param index
     * @param element
     *
     * @throws IndexOutOfBoundsException if the specified index is out of range
     */
    void add(int index, T element);

    /**
     * This method appends the specified element to the end of this list
     * @param element
     */
    void add(T element);

    /**
     * This method inserts all the elements in the specified collection into this list, starting at the specified position
     * @param index
     * @param c
     */
    void addAll(int index, Collection<T> c);

    /**
     * This method appends all of the elements in the specified collection to the end of this list, in the order that they are returned
     * by the specified collection's iterator
     * @param c
     */
    void addAll(Collection<T> c);

    /**
     * This method inserts the specified element at the beginning of this list
     * @param element
     */
    void addFirst(T element);

    /**
     * This method Appends the specified element to the end of this list
     * @param element
     */
    void addLast(T element);

    /**
     * This method removes all of the elements from this list
     */
    void clear();

    /**
     * This method returns the element at the specified position in this list
     * @param index
     * @return
     */
    T get(int index);

    /**
     * This method returns the first element in this list
     * @return
     */
    T getFirst();

    /**
     * This method returns the last element in this list
     * @return
     */
    T getLast();

    /**
     * This method returns the index of the first occurrence of the specified element in this list, or -1 if this list
     * does not contain the element
     * @param t
     * @return
     */
    int indexOf(T t);

    /**
     * This method retrieves and removes the head (first element) of this list
     * @return
     */
    T remove();

    /**
     * This method removes the element at the specified position in this list
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * This method removes the first occurrence of the specified element from this list, if it is present
     * @param e
     * @return
     */
    boolean remove(T e);

    /**
     * This method returns the number of elements in this list
     * @return
     */
    int size();

    /**
     * This method replaces the element at the specified position in this list with the specified element
     * @param index
     * @param element
     */
    void set(int index, T element);
}