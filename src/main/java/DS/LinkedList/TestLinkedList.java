package DS.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insert(8);
        linkedList.insert(5);
        linkedList.insert(13);
        linkedList.removeAt(0);
        //linkedList.insterAt(0,3);
        linkedList.show();
        System.out.println(linkedList.size());

    }
}
