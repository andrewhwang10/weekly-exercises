import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class TestTreeNode {
	
	protected TreeNode a, b, c, d, root, root2;
	/* Diagram:
	 * 							  Level
	 *		root		root2   |   0 
	 *		 /\			  \		|	
	 *		a  d		   b	|	1
	 * 	   /					|
	 *    c						|	2		*/
	
	protected void setUp() {
		root = new TreeNode();
		a = new TreeNode(root, 1);
		root.left = a;
		c = new TreeNode(a, 2);
		a.left = c;
		
		TreeNode root2 = new TreeNode();
		TreeNode b = new TreeNode(root2, 1);
		root2.right = b;
		TreeNode d = new TreeNode(root, 1);
		root.right = d;
    }
	
	@Test
	public void testLowestCommonAncestor() {
		//Test Case 1: Not in same tree
		assertNull(TreeNode.lowestCommonAncestor(a, b));
		
		//Test Case 2: C is child of A
		assertEquals(TreeNode.lowestCommonAncestor(a, c), a);
		
		//Test Case 3: Direct descendants of root
		assertEquals(TreeNode.lowestCommonAncestor(a, d), root);
		
		// Test case 4: Different levels
		assertEquals(TreeNode.lowestCommonAncestor(b, c), root);
	}
}