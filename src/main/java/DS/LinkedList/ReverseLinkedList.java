package DS.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        recReverseSolution(null, null);
    }

    public static void recReverseSolution(Node currentNode, Node prev) {
        if (currentNode == null)
            return;
        Node next = currentNode.next;
        currentNode.next = prev;
        recReverseSolution(next, currentNode);
    }

}
