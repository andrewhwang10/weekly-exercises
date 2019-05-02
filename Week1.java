public class Week1 {
    class Node {
        public Node next;
        public int data;
    }

    public static Node reverseLinkedList(Node head) {
        Node prev, next;
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
        Node cur = head;
        Node curA = listA;
        Node curB = curB;
        while(curA != null && curB != null) {
            if(curA.data < curB.data) {
                cur.next = curA;
                curA = curA.next; 
            } else {
                cur.next = curB;
                curB = curB.next;
            }
        }
        if(curA != null) {
            cur.next = curA;
        } else if(curB != null) {
            cur.next = curB;
        }
        
        return head.next;
    }
}