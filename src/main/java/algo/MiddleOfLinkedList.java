package algo;

public class MiddleOfLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        int count = (int) Math.round(getsize(head) / 2 + 0.5);
        ListNode node = head;
        while (count == 1) {
            node = node.next;
            count--;
        }
        return node;
    }

    public int getsize(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node.next != null) {
            count++;
            node = node.next;
        }

        return count++;
    }
}

