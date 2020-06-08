package DS.Stack;

import DS.LinkedList.LinkedList;

public class StackUsingLinkedList<T> {

    public class Node {
        int value;
        Node prev;
        int min;
    }


    Node top;
    int size = 0;
    int min;

    StackUsingLinkedList() {
    }

    public void push(int value) {
        if (top == null) {
            Node node = new Node();
            node.value = value;
            node.min = value;
            top = node;
        } else {
            Node node = new Node();
            node.value = value;
            node.prev = top;
            node.min = Math.min(top.min, value);
            top = node;
        }
        size++;
    }

    public int pop() {
        if (top == null) {
            throw new IndexOutOfBoundsException(
                    "stack is empty"
            );
        }
        Node n = top;
        int value = top.value;
        top = top.prev;
        n = null;
        size--;
        return value;

    }

    public int peek() {
        return top.value;
    }

    public int size() {
        return size;
    }

    public void show() {
        Node node = top;
        while (node.prev != null) {
            System.out.print("|" + node.value + "/" + node.min + "|<");
            node = node.prev;
        }
        System.out.print("|" + node.value + "/" + node.min + "|");

    }

    public int getMin() {
        return top.min;
    }

}




