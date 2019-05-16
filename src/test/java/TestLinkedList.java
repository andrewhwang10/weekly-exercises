import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestLinkedList {
    
    protected LinkedList list, reversedList;

    protected void setUp() {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        reversedList = new LinkedList();
        reversedList.add(3);
        reversedList.add(2);
        reversedList.add(1);
    }

    @Test
    public void testReverseLinkedList() {
        list.reverse();
        assertEquals(list, reversedList);
    }

    @Test
    public void testMergeLinkedLists() {
        LinkedList listA = new LinkedList(3);
        LinkedList listB = new LinkedList(3);
        LinkedList expected = new LinkedList();
        for(int i = 0; i < 3; i++) {
        	expected.add(i);
        	expected.add(i);
        }
        
        LinkedList result = LinkedList.mergeLinkedLists(listA, listB);
        assertEquals(result, expected);
        
    }
}