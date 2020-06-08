package DS.Stack;

import java.util.Arrays;
import java.util.Objects;

public class StackUsingArray<T> {
    int capacity = 2;
    T[] stack;
    int top = 0;

    StackUsingArray() {
        //this.capacity = capacity;
        stack = (T[]) new Object[capacity];
    }

    public void push(T value) {
        if (size() >= capacity) {
            expand();
        }
        stack[top] = value;
        top++;
    }

    public T pop() {
        if (size() <= capacity / 2)
            shirnk();
        top--;
        T value = stack[top];
        stack[top] = null;
        return value;
    }

    public T peek() {
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public void show() {
        System.out.println(Arrays.toString(stack));
    }

    public void expand() {
        capacity *= 2;
        T[] newStack = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, top);
        stack = newStack;
    }


    public void shirnk() {
        capacity = capacity / 2;
        T[] newStack = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, top);
        stack = newStack;
    }
}
