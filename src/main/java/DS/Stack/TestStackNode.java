package DS.Stack;

public class TestStackNode {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(10);
        stack.show();
        System.out.println("Size is " + stack.size());
        System.out.println("Min is " + stack.getMin());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        System.out.println("Min is " + stack.getMin());
        stack.pop();
        System.out.println("Min is " + stack.getMin());
        stack.pop();
        System.out.println("Min is " + stack.getMin());
        stack.show();
    }
}
