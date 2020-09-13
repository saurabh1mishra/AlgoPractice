package DS.Tree;

public class ReverseTree {

    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(3);
        TreeNode leaf3 = new TreeNode(6);
        TreeNode leaf4 = new TreeNode(9);
        TreeNode nodeRight = new TreeNode(7, leaf3, leaf4);
        TreeNode nodeLeft = new TreeNode(2, leaf1, leaf2);
        TreeNode root = new TreeNode(4, nodeLeft, nodeRight);

    }


    public void reverseRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode.getLeftChild();
        treeNode.setLeftChild(treeNode.getRightChild());
        treeNode.setRightChild(temp);
        reverseRecursive(treeNode.getLeftChild());
        reverseRecursive(treeNode.getRightChild());
    }


}
