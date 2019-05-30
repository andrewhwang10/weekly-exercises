import java.util.*;

public class LinkedList {
	private ListNode head;
	private ListNode tail; //For the purpose of adding in O(1) time
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	/* Constructor that creates list of size with nodes that represent their index */
	public LinkedList(int size) {
		for(int i = 0; i < size; i++) {
			add(new ListNode(i));
		}
	}
	
	public void add(ListNode node) {
		if(head == null && tail == null) { //Empty LinkedList case
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}
	
	public ListNode pop() {
		if(head == null) {
			throw new NullPointerException();
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	
	public ListNode peek() {
		if(head == null) {
			throw new NullPointerException();
		}
		return this.head;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void reverse() {
		tail = head;
		ListNode prev = null;
		ListNode next = null;
		ListNode cur = head;
		while(cur != null) {
		    next = cur.next;
		    cur.next = prev;
		    prev = cur;
		    cur = next;
		}
		head = prev;
	}
	
	public static boolean isCyclical(LinkedList listA) {
		Set<ListNode> visited = new HashSet<>();
		ListNode cur = listA.head;
		while(cur != null) {
			if(visited.contains(cur)) {
				return true;
			}
			visited.add(cur);
			cur = cur.next;
		}
		
		return false;
	}
	
	public static LinkedList mergeLinkedLists(LinkedList listA, LinkedList listB) {
        LinkedList merged = new LinkedList();
        while(!listA.isEmpty() && !listB.isEmpty()) {
        	ListNode toAdd = smallerFirstElement(listA, listB);
        	merged.add(toAdd);
        }
        if(!listA.isEmpty()) {
        	merged.add(listA.head);
        } else if(!listB.isEmpty()) {
        	merged.add(listB.head);
        }
        
        return merged;
    }
	
	private static ListNode smallerFirstElement(LinkedList listA, LinkedList listB) {
		if(listA.peek().data < listB.peek().data) {
			return listA.pop();
		} else {
			return listB.pop();
		}
	}
	
}

