public class Week1 {
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

    public static Node mergeLinkedLists(ListNode listA, ListNode listB) {h
        ListNode head = new ListNode();
        mergeLinkedLists(head, listA, listB);
        return head.next;
    }

    private static void mergeLinkedLists(ListNode merged, ListNode a, ListNode b) {
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

class ListNode {
    public ListNode next;
    public int data;

    public ListNode(int data) {
        this.data = data;
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
}