import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLinkedList {
    
    private LinkedList list;

    @BeforeEach
    private void setup() {
        list = new LinkedList();
    }
    
    @Test
    public void testForCycles() {
    	ListNode one = new ListNode(1);
    	ListNode two = new ListNode(2);
    	ListNode three = new ListNode(3);
    	list.add(one);
    	list.add(two);
    	list.add(three);
    	list.add(one);
    	
    	assertTrue(LinkedList.isCyclical(list));
    	
    	list.pop();
    	
    	assertFalse(LinkedList.isCyclical(list));
    }
    
    @Test
    public void testReverseLinkedList() {
    	list.add(new ListNode(1));
    	list.add(new ListNode(2));
    	list.add(new ListNode(3));
    	
    	LinkedList reversedList = new LinkedList();
    	reversedList.add(new ListNode(3));
    	reversedList.add(new ListNode(2));
    	reversedList.add(new ListNode(1));
    	
        list.reverse();
        while(!list.isEmpty()) {
        	assertEquals(list.pop().data, reversedList.pop().data);
        }
        assertTrue(reversedList.isEmpty());        
    }

    @Test
    public void testMergeLinkedLists() {
    	ListNode one = new ListNode(1);
    	ListNode three = new ListNode(3);
    	ListNode five = new ListNode(5);
    	list.add(one);
    	list.add(three);
    	list.add(five);
  
        LinkedList listB = new LinkedList(3);
                
        LinkedList expected = new LinkedList();
        expected.add(new ListNode(0));
        expected.add(new ListNode(1));
        expected.add(new ListNode(1));
        expected.add(new ListNode(2));
        expected.add(new ListNode(3));
        expected.add(new ListNode(5));
        
        LinkedList result = LinkedList.mergeLinkedLists(list, listB);
       
        while(!result.isEmpty()) {
        	assertEquals(result.pop().data, expected.pop().data);
        }        
        assertTrue(expected.isEmpty());
    }
}