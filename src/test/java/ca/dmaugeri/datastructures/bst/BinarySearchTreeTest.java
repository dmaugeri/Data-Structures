package ca.dmaugeri.datastructures.bst;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.function.Consumer;

public class BinarySearchTreeTest {

    @Test
    public void makeSureInsertWorksProperly() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(12);
        binarySearchTree.insert(40);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(41);

        Consumer<Integer> consumer = Mockito.mock(Consumer.class);
        InOrder inOrder = Mockito.inOrder(consumer);

        binarySearchTree.inOrderTraversal(consumer);

        inOrder.verify(consumer).accept(6);
        inOrder.verify(consumer).accept(12);
        inOrder.verify(consumer).accept(15);
        inOrder.verify(consumer).accept(20);
        inOrder.verify(consumer).accept(40);
        inOrder.verify(consumer).accept(41);
    }
}
