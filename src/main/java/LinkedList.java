public class LinkedList {
	private ListNode head;
	private ListNode tail; //For the purpose of adding in O(1) time
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(int number) {
		addNode(new ListNode(number));
	}
	
	private void addNode(ListNode node) {
		if(head == null && tail == null) { //Empty LinkedList case
			head = node;
			tail = head;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}
	
	public int pop() {
		return popNode().data;		
	}
	
	private ListNode popNode() {
		if(head == null) {
			throw new NullPointerException();
		}
		ListNode temp = head;
		head = head.next;
		return temp;
	}
	
	public int peek() {
		if(head == null) {
			throw new NullPointerException();
		}
		return this.head.data;
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
	
	public static LinkedList mergeLinkedLists(LinkedList listA, LinkedList listB) {
        LinkedList merged = new LinkedList();
        while(!listA.isEmpty() && !listB.isEmpty()) {
        	ListNode toAdd = smallerFirstElement(listA, listB);
        	merged.addNode(toAdd);
        }
        if(!listA.isEmpty()) {
        	merged.addNode(listA.head);
        } else if(!listB.isEmpty()) {
        	merged.addNode(listB.head);
        }
        
        return merged;
    }
	
	private static ListNode smallerFirstElement(LinkedList listA, LinkedList listB) {
		if(listA.peek() < listB.peek()) {
			return listA.popNode();
		} else {
			return listB.popNode();
		}
	}
	
	private class ListNode {
	    public ListNode next;
	    public int data;
	    
	    public ListNode() {
	    	this.next = null;
	    	this.data = -1;
	    }
	    
	    public ListNode(int data) {
	        this.data = data;
	    }
	}
}

