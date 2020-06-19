package ca.dmaugeri.datastructures.bst;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.function.Consumer;

public class BinarySearchTreeTest {

    @Test
    public void shouldProperlyInsertNodesAndCompleteInOrderTraversal() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(17);
        binarySearchTree.insert(13);
        binarySearchTree.insert(30);
        binarySearchTree.insert(41);
        binarySearchTree.insert(35);

        Consumer<Integer> consumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(consumer);

        binarySearchTree.inOrderTraversal(consumer);

        inOrder.verify(consumer).accept(6);
        inOrder.verify(consumer).accept(12);
        inOrder.verify(consumer).accept(13);
        inOrder.verify(consumer).accept(15);
        inOrder.verify(consumer).accept(17);
        inOrder.verify(consumer).accept(20);
        inOrder.verify(consumer).accept(30);
        inOrder.verify(consumer).accept(35);
        inOrder.verify(consumer).accept(40);
        inOrder.verify(consumer).accept(41);
    }

    @Test
    public void shouldProperlyCompleteAPreOrderTraversal() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(17);
        binarySearchTree.insert(13);
        binarySearchTree.insert(30);
        binarySearchTree.insert(41);
        binarySearchTree.insert(35);

        Consumer<Integer> consumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(consumer);

        binarySearchTree.preOrderTraversal(consumer);

        inOrder.verify(consumer).accept(20);
        inOrder.verify(consumer).accept(12);
        inOrder.verify(consumer).accept(6);
        inOrder.verify(consumer).accept(15);
        inOrder.verify(consumer).accept(13);
        inOrder.verify(consumer).accept(17);
        inOrder.verify(consumer).accept(40);
        inOrder.verify(consumer).accept(30);
        inOrder.verify(consumer).accept(35);
        inOrder.verify(consumer).accept(41);
    }

    @Test
    public void shouldProperlyCompleteAPostOrderTraversal() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(17);
        binarySearchTree.insert(13);
        binarySearchTree.insert(30);
        binarySearchTree.insert(41);
        binarySearchTree.insert(35);

        Consumer<Integer> consumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(consumer);

        binarySearchTree.postOrderTraversal(consumer);

        inOrder.verify(consumer).accept(6);
        inOrder.verify(consumer).accept(13);
        inOrder.verify(consumer).accept(17);
        inOrder.verify(consumer).accept(15);
        inOrder.verify(consumer).accept(12);
        inOrder.verify(consumer).accept(35);
        inOrder.verify(consumer).accept(30);
        inOrder.verify(consumer).accept(41);
        inOrder.verify(consumer).accept(40);
        inOrder.verify(consumer).accept(20);
    }

    @Test
    public void shouldProperlyDeleteWhenNodeHasNoLeafChildren() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(6);

        binarySearchTree.delete(6);

        Consumer<Integer> inOrderConsumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(inOrderConsumer);

        binarySearchTree.inOrderTraversal(inOrderConsumer);

        inOrder.verify(inOrderConsumer).accept(12);
        inOrder.verify(inOrderConsumer).accept(20);
        inOrder.verify(inOrderConsumer).accept(40);
        Mockito.verify(inOrderConsumer, Mockito.times(3)).accept(Mockito.anyInt());
    }

    @Test
    public void shouldProperlyDeleteWhenNodeOnlyHasASingleRightChild() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

//                20
//              /    \
//             12    40
//               \
//               15
//              /  \
//             13  17
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(15);
        binarySearchTree.insert(13);
        binarySearchTree.insert(17);

        binarySearchTree.delete(12);


        Consumer<Integer> inOrderConsumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(inOrderConsumer);

        binarySearchTree.inOrderTraversal(inOrderConsumer);

        inOrder.verify(inOrderConsumer).accept(13);
        inOrder.verify(inOrderConsumer).accept(15);
        inOrder.verify(inOrderConsumer).accept(17);
        inOrder.verify(inOrderConsumer).accept(20);
        inOrder.verify(inOrderConsumer).accept(40);
        Mockito.verify(inOrderConsumer, Mockito.times(5)).accept(Mockito.anyInt());
    }

    @Test
    public void shouldProperlyDeleteWhenNodeOnlyHasASingleLeftChild() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

//                20
//              /    \
//             12    40
//                  /
//                 30
//                /  \
//               25   31
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(30);
        binarySearchTree.insert(25);
        binarySearchTree.insert(31);


        binarySearchTree.delete(40);


        Consumer<Integer> inOrderConsumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(inOrderConsumer);

        binarySearchTree.inOrderTraversal(inOrderConsumer);

        inOrder.verify(inOrderConsumer).accept(12);
        inOrder.verify(inOrderConsumer).accept(20);
        inOrder.verify(inOrderConsumer).accept(25);
        inOrder.verify(inOrderConsumer).accept(30);
        inOrder.verify(inOrderConsumer).accept(31);

        Mockito.verify(inOrderConsumer, Mockito.times(5)).accept(Mockito.anyInt());
    }

    @Test
    public void shouldProperlyDeleteWhenNodeHasTwoChildren() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

//                  20
//                /    \
//              12      40
//                   /      \
//                 30       50
//                /  \    /   \
//              25    31 45    52
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(30);
        binarySearchTree.insert(25);
        binarySearchTree.insert(31);
        binarySearchTree.insert(50);
        binarySearchTree.insert(45);
        binarySearchTree.insert(52);

        binarySearchTree.delete(40);


        Consumer<Integer> inOrderConsumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(inOrderConsumer);

        binarySearchTree.inOrderTraversal(inOrderConsumer);

        inOrder.verify(inOrderConsumer).accept(12);
        inOrder.verify(inOrderConsumer).accept(20);
        inOrder.verify(inOrderConsumer).accept(25);
        inOrder.verify(inOrderConsumer).accept(30);
        inOrder.verify(inOrderConsumer).accept(31);
        inOrder.verify(inOrderConsumer).accept(45);
        inOrder.verify(inOrderConsumer).accept(50);
        inOrder.verify(inOrderConsumer).accept(52);
        Mockito.verify(inOrderConsumer, Mockito.times(8)).accept(Mockito.anyInt());
    }
}
