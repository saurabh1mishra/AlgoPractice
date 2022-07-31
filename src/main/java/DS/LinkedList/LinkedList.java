package DS.LinkedList;

public class LinkedList<T> {

    private Node<T> head;

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void show() {
        Node<T> n = head;
        while (n.next != null) {
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
    }

    public void insertAtFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
    }

    public void removeFirst() {
        Node<T> n = head;
        head = head.next;
        n = null;
    }

    public void insterAt(int index, T value) {
        if (size() < index) {
            throw new IllegalStateException("array size is less the index");
        }
        Node<T> node = new Node<>(value);
        if (index == 0) {
            insertAtFirst(value);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void removeAt(int index) {
        if (size() <= index) {
            throw new IllegalStateException("array size is less the index");
        }
        if (index == 0) {
            removeFirst();
        } else {

            Node<T> n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            Node nodeTBD = n.next;
            n.next = nodeTBD.next;
            nodeTBD = null;
        }
    }

    public int size() {
        if (head == null)
            return 0;
        Node n = head;
        int count = 0;
        while (n.next != null) {
            count++;
            n = n.next;
        }
        return ++count;
    }


}
