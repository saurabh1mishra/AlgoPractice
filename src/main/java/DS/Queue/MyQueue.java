package DS.Queue;

public class MyQueue<k> {

    Node<k> head;
    Node<k> tail = null;

    public void enqueue(k value) {
        Node<k> tobeAdded = new Node<>(value);
        if (head == null) {
            head = tail = tobeAdded;
            return;
        }
        tail.next = tobeAdded;
        tail = tobeAdded;
    }

    public k peek() {
        if (head == null)
            return null;
        return head.value;

    }

    public k dequeue() {
        if (head == null)
            return null;
        Node<k> temp = head;
        head = temp.next;
        // If front becomes NULL, then change rear also as NULL
        if (this.head == null)
            this.tail = null;
        return temp.value;
    }


}
