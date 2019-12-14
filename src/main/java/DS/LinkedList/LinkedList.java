package DS.LinkedList;

public class LinkedList {

    private Node head;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
    }

    public void insertAtFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void removeFirst() {
        Node n = head;
        head = head.next;
        n = null;
    }

    public void insterAt(int index, int value) {
        if (size() < index) {
            throw new IllegalStateException("array size is less the index");
        }
        Node node = new Node(value);
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

            Node n = head;
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
