package DS.Stack;

public class TestArray {

    public static void main(String[] args) {
        StackUsingArray<Integer> stack = new StackUsingArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(10);
        stack.show();
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.show();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
    }
}
