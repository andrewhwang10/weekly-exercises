public class Week1 {
    class Node {
        public Node next;
        public int data;
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node next = null;
        Node cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static Node mergeLinkedLists(Node listA, Node listB) {
        Node head = new Node();
        mergeLinkedLists(head, listA, listB);
        return head;
    }

    private static void mergeLinkedLists(Node merged, Node a, Node b) {
        if(a == null) {
            merged.next = b;
        } else if(b == null) {
            merged.next = a;
        } else {
            if(a.data < b.data) {
                merged.next = a
                mergeLinkedLists(merged, a.next, b);
            } else {
                merged.next = b;
                mergeLinkedLists(merged, a, b.next);
            }
        }
    }
}