package DS.Tree;

public class TreeNode {

    private int value;
    private TreeNode rightChild;
    private TreeNode leftChild;

    public TreeNode(int value) {
        this.value = value;
        this.rightChild = null;
        this.leftChild = null;
    }

    public TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }


    public int getValue() {
        return value;
    }


    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
}
