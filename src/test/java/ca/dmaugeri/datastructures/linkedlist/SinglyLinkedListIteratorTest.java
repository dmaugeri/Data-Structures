package ca.dmaugeri.datastructures.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SinglyLinkedListIteratorTest {

    @Test
    public void shouldCorrectlyGrabTheNextElement() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("efg");
        Iterator<String> iterator = singlyLinkedList.iterator();
        Assert.assertEquals("abc", iterator.next());
        Assert.assertEquals("efg", iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionCallingNextWhenNoElementIsNext() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("efg");
        Iterator<String> iterator = singlyLinkedList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void shouldProperlyDetectHasNext() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("def");
        Iterator<String> iterator = singlyLinkedList.iterator();

        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowInvalidStateExceptionIfYouCallRemoveBeforeNext() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("def");
        Iterator<String> iterator = singlyLinkedList.iterator();

        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowInvalidStateExceptionIfYouCallRemoveTwiceInARow() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("def");
        Iterator<String> iterator = singlyLinkedList.iterator();

        iterator.next();
        iterator.remove();
        iterator.remove();
    }

    @Test
    public void shouldProperlyRemoveAllTheElements() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("def");
        singlyLinkedList.add("ghi");
        Iterator<String> iterator = singlyLinkedList.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("abc", singlyLinkedList.get(0));
        Assert.assertEquals("abc", iterator.next());
        iterator.remove();

        Assert.assertEquals("def", iterator.next());
        Assert.assertEquals("def", singlyLinkedList.get(0));
        Assert.assertTrue(iterator.hasNext());
        iterator.remove();

        Assert.assertEquals("ghi", iterator.next());
        Assert.assertEquals("ghi", singlyLinkedList.get(0));
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldProperlyIterateThroughTheRemainingElements() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("def");
        singlyLinkedList.add("ghi");
        singlyLinkedList.add("jkl");
        singlyLinkedList.add("mno");

        Iterator<String> iterator = singlyLinkedList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();

        // TODO: this throws a warning in JDK 11 for whatever reason, but not JDK 8. I might need to upgrade Mockito at some point
        Consumer<String> consumer = Mockito.mock(Consumer.class);
        iterator.forEachRemaining(consumer);
        Mockito.verify(consumer).accept("jkl");
        Mockito.verify(consumer).accept("mno");
        Mockito.verify(consumer, Mockito.times(2)).accept(Mockito.anyString());
    }
}
