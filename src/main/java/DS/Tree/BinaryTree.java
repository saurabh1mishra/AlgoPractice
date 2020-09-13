package DS.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.getValue()) {
            current.setLeftChild(addRecursive(current.getLeftChild(), value));
        } else if (value > current.getValue()) {
            current.setRightChild(addRecursive(current.getRightChild(), value));
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (current.getValue() == value)
            return true;
        return (current.getValue() > value) ?
                containsNodeRecursive(current.getLeftChild(), value) : containsNodeRecursive(current.getRightChild(), value);

    }


    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRightChild());
        }
    }

    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeftChild());
            traversePreOrder(node.getRightChild());
        }
    }

    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            System.out.print(" " + node.getValue());
        }
    }

    public void traverseLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            System.out.print(" " + node.getValue());

            if (node.getLeftChild() != null) {
                nodes.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                nodes.add(node.getRightChild());
            }
        }
    }
}


