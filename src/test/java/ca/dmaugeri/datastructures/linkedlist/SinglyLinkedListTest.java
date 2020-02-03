package ca.dmaugeri.datastructures.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedListTest {
    @Test
    public void testAddWithIndexWorksProperly() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0, "test");
        singlyLinkedList.add(1, "another");
        singlyLinkedList.add(2, "great");
        singlyLinkedList.add(3, "one");

        Assert.assertEquals("test", singlyLinkedList.get(0));
        Assert.assertEquals("another", singlyLinkedList.get(1));
        Assert.assertEquals("great", singlyLinkedList.get(2));
        Assert.assertEquals("one", singlyLinkedList.get(3));
        Assert.assertEquals(4, singlyLinkedList.size());
        Assert.assertEquals(4, singlyLinkedList.size());
        Assert.assertEquals("[test, another, great, one]", singlyLinkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testShouldThrowAnIndexOutOfBoundsExceptionIfTheIndexDoesNotExist() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0, "test");
        singlyLinkedList.add(3, "another");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testShouldThrowAnIndexOutOfBoundsExceptionIfTheIndexIsLessThanZero() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(-1, "test");
    }

    @Test
    public void testAddWithNoIndex() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("test");
        singlyLinkedList.add("asdf");
        singlyLinkedList.add("abc");

        Assert.assertEquals("test", singlyLinkedList.get(0));
        Assert.assertEquals("asdf", singlyLinkedList.get(1));
        Assert.assertEquals("abc", singlyLinkedList.get(2));
        Assert.assertEquals(3, singlyLinkedList.size());
        Assert.assertEquals("[test, asdf, abc]", singlyLinkedList.toString());
    }

    @Test
    public void testAddLast() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addLast("abc");
        singlyLinkedList.addLast("efc");
        singlyLinkedList.addLast("xyz");

        Assert.assertEquals("abc", singlyLinkedList.get(0));
        Assert.assertEquals("efc", singlyLinkedList.get(1));
        Assert.assertEquals("xyz", singlyLinkedList.get(2));
        Assert.assertEquals(3, singlyLinkedList.size());
        Assert.assertEquals("[abc, efc, xyz]", singlyLinkedList.toString());
    }

    @Test
    public void testGetFirst() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add(0,"efc");
        singlyLinkedList.addFirst("xyz");

        Assert.assertEquals("xyz", singlyLinkedList.getFirst());
        Assert.assertEquals(3, singlyLinkedList.size());
        Assert.assertEquals("[xyz, efc, abc]", singlyLinkedList.toString());
    }

    @Test
    public void testGetLast() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addLast("abc");
        singlyLinkedList.add(0,"efc");
        singlyLinkedList.addFirst("xyz");

        Assert.assertEquals("abc", singlyLinkedList.getLast());
        Assert.assertEquals(3, singlyLinkedList.size());
        Assert.assertEquals("[xyz, efc, abc]", singlyLinkedList.toString());
    }

    @Test
    public void testRemove() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("efc");
        singlyLinkedList.add("xyz");
        singlyLinkedList.add("lmn");

        Assert.assertEquals("lmn", singlyLinkedList.remove(3));
        Assert.assertEquals("xyz", singlyLinkedList.get(2));
        Assert.assertEquals("efc", singlyLinkedList.remove(1));
        Assert.assertEquals("xyz", singlyLinkedList.get(1));
        Assert.assertEquals("abc", singlyLinkedList.remove(0));
        Assert.assertEquals("xyz", singlyLinkedList.get(0));
        Assert.assertEquals(1, singlyLinkedList.size());
        Assert.assertEquals("[xyz]", singlyLinkedList.toString());
    }

    @Test
    public void testAddCollectionAtIndex() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.add("efc");

        List<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");

        List<String> secondCollection = new ArrayList<>();
        secondCollection.add("3");
        secondCollection.add("4");

        List<String> thirdCollection = new ArrayList<>();
        thirdCollection.add("5");

        List<String> fourthCollection = new ArrayList<>();

        singlyLinkedList.addAll(0, collection);
        singlyLinkedList.addAll(3, secondCollection);
        singlyLinkedList.addAll(6, thirdCollection);
        singlyLinkedList.addAll(0, fourthCollection);

        Assert.assertEquals("1", singlyLinkedList.get(0));
        Assert.assertEquals("2", singlyLinkedList.get(1));
        Assert.assertEquals("abc", singlyLinkedList.get(2));
        Assert.assertEquals("3", singlyLinkedList.get(3));
        Assert.assertEquals("4", singlyLinkedList.get(4));
        Assert.assertEquals("efc", singlyLinkedList.get(5));
        Assert.assertEquals("5", singlyLinkedList.get(6));
        Assert.assertEquals(7, singlyLinkedList.size());
        Assert.assertEquals("[1, 2, abc, 3, 4, efc, 5]", singlyLinkedList.toString());
    }

    @Test
    public void testClear() {
        //TODO: use the iterator to test the clear
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addAll(0, new ArrayList<>(List.of("abc", "123")));
        singlyLinkedList.add("xyz");
        singlyLinkedList.addFirst("123");
        singlyLinkedList.addLast("ajklsdfjkl");
        singlyLinkedList.clear();
        Assert.assertEquals("[]", singlyLinkedList.toString());
        Assert.assertEquals(0, singlyLinkedList.size());
    }

    @Test
    public void testRemoveByElement() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addAll(0, new ArrayList<>(List.of("abc", "123")));
        singlyLinkedList.add("xyz");
        singlyLinkedList.addFirst("123");
        singlyLinkedList.addLast("ajklsdfjkl");

        Assert.assertTrue(singlyLinkedList.remove("ajklsdfjkl"));
        Assert.assertEquals(4, singlyLinkedList.size());
        Assert.assertEquals("[123, abc, 123, xyz]", singlyLinkedList.toString());
        Assert.assertTrue(singlyLinkedList.remove("123"));
        Assert.assertEquals("[abc, 123, xyz]", singlyLinkedList.toString());
        Assert.assertEquals(3, singlyLinkedList.size());
        Assert.assertFalse(singlyLinkedList.remove("sdfjklasdfjkl;asdfjkl;sdfjkl;sdfa"));
    }

    @Test
    public void testIndexOfAnElement() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addAll(0, new ArrayList<>(List.of("abc", "def")));
        singlyLinkedList.add(0, "efg");
        singlyLinkedList.add("lmn");
        Assert.assertEquals(0, singlyLinkedList.indexOf("efg"));
        Assert.assertEquals(1, singlyLinkedList.indexOf("abc"));
        Assert.assertEquals(2, singlyLinkedList.indexOf("def"));
        Assert.assertEquals(3, singlyLinkedList.indexOf("lmn"));
        Assert.assertEquals(-1, singlyLinkedList.indexOf(null));

        singlyLinkedList.add(1, null);
        Assert.assertEquals(1, singlyLinkedList.indexOf(null));
    }

    @Test
    public void testAddAllWithACollection() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("abc");
        singlyLinkedList.addAll(List.of("def", "ghi", "jkl"));
        Assert.assertEquals(4, singlyLinkedList.size());
        Assert.assertEquals("[abc, def, ghi, jkl]", singlyLinkedList.toString());
    }

    @Test
    public void testSetElement() {
        LinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addAll(List.of("abc", "def", "jkl", "mno", "pqr"));
        singlyLinkedList.set(0, "123");
        singlyLinkedList.set(4, "456");
        singlyLinkedList.set(2, "789");
        Assert.assertEquals(5, singlyLinkedList.size());
        Assert.assertEquals("[123, def, 789, mno, 456]", singlyLinkedList.toString());
    }
}
