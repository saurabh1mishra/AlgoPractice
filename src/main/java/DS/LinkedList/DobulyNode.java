package DS.LinkedList;

import java.util.Optional;

public class DobulyNode<T> {
    private T value;
    private DobulyNode<T> next;
    private DobulyNode<T> privious;

    public DobulyNode(T value, DobulyNode<T> next, DobulyNode<T> pre) {
        this.value = value;
        this.next = next;
        this.privious = pre;
    }

    public T getValue() {
        return value;
    }

    public Optional<DobulyNode<T>> getNext() {
        return Optional.ofNullable(next);
    }

    public Optional<DobulyNode<T>> getPrivious() {
        return Optional.ofNullable(privious);
    }
}
