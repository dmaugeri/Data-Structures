package ca.dmaugeri.datastructures.bst;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinarySearchTreeNode<T> root;

    public BinarySearchTree() {
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private BinarySearchTreeNode<T> insert(BinarySearchTreeNode<T> subRoot, T value) {
        if (subRoot == null) {
            subRoot = new BinarySearchTreeNode<T>(value);
            return subRoot;
        }

        if (value.compareTo(subRoot.getValue()) < 0) {
            subRoot.setLeft(insert(subRoot.getLeft(), value));
        } else if (value.compareTo(subRoot.getValue()) >= 0) {
            subRoot.setRight(insert(subRoot.getRight(), value));
        }

        return subRoot;
    }

    public void delete(T element) {
        root = delete(root, element);
    }

    private BinarySearchTreeNode<T> delete(BinarySearchTreeNode<T> node, T element) {
        if (node == null) {
            return null;
        }

        if (element.compareTo(node.getValue()) < 0) {
            node.setLeft(delete(node.getLeft(), element));
        } else if (element.compareTo(node.getValue()) > 0) {
            node.setRight(delete(node.getRight(), element));
        } else {
            // we found the node to delete

            // if they only have one child we can just return the child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            BinarySearchTreeNode<T> minNode = findMinNode(node.getRight());
            node.setValue(minNode.getValue());
            node.setRight(delete(node.getRight(), minNode.getValue()));
        }

        return node;
    }

    public BinarySearchTreeNode<T> findMinNode(BinarySearchTreeNode<T> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return findMinNode(node.getLeft());
    }


    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(BinarySearchTreeNode<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        inOrderTraversal(node.getRight(), consumer);
    }

    public void preOrderTraversal(Consumer<T> consumer) {
        preOrderTraversal(root, consumer);
    }

    private void preOrderTraversal(BinarySearchTreeNode<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.getValue());
        preOrderTraversal(node.getLeft(), consumer);
        preOrderTraversal(node.getRight(), consumer);
    }

    public void postOrderTraversal(Consumer<T> consumer) {
        postOrderTraversal(root, consumer);
    }

    private void postOrderTraversal(BinarySearchTreeNode<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft(), consumer);
        postOrderTraversal(node.getRight(), consumer);
        consumer.accept(node.getValue());
    }
}
