package DS.LinkedList;

import java.util.Optional;

public class Node<T> {
    T value;

    Node<T> next;

    Node(T value) {
        this.value = value;
    }

    public Optional<Node<T>> getNext() {
        return Optional.ofNullable(next);
    }
}
