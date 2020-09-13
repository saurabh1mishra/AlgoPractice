package DS.Stack;

/**
 * link : https://leetcode.com/problems/min-stack/
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


class MinStack {

    /**
     * initialize your data structure here.
     */
    Node top;
    int size = 0;
    int min;

    public class Node {
        int value;
        Node prev;
        int min;
    }

    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            Node node = new Node();
            node.value = x;
            node.min = x;
            top = node;
        } else {
            Node node = new Node();
            node.value = x;
            node.prev = top;
            node.min = Math.min(top.min, x);
            top = node;
        }
        size++;
    }

    public void pop() {
        if (top == null) {
            throw new IndexOutOfBoundsException("stack is empty");
        }
        Node n = top;
        top = top.prev;
        n = null;
        size--;
    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return top.min;
    }
}
