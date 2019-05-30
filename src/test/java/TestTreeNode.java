import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTreeNode {
	
	private TreeNode root; 
	
	@BeforeEach
	private void setup() {
		root = new TreeNode();
	}
	
	@Test
	public void testTreeNodesInSeperateTrees() {
		TreeNode child = new TreeNode(root, 1);
		root.left = child;
		
		TreeNode otherRoot = new TreeNode();
		TreeNode otherChild = new TreeNode(otherRoot, 1);
		otherRoot.right = otherChild;
		
		assertNull(TreeNode.lowestCommonAncestor(child, otherChild));
	}
	
	@Test
	public void testDirectChildrenNodesOfRoot() {
		root.left = new TreeNode(root, 1);
		root.right = new TreeNode(root, 1);
		
		assertEquals(TreeNode.lowestCommonAncestor(root.left, root.right), root);
	}
	
	@Test
	public void testTreeWithLongLeft() {
		root.left = new TreeNode(root, 1);
		root.left.left = new TreeNode(root.left, 2);
		
		assertEquals(TreeNode.lowestCommonAncestor(root.left.left, root.left), root.left);
	}
	
	@Test
	public void testTreeNodesOnDifferentLevels() {
		root.left = new TreeNode(root, 1);
		root.right = new TreeNode(root, 1);
		root.right.right = new TreeNode(root.right, 2);
		
		assertEquals(TreeNode.lowestCommonAncestor(root.left, root.right), root);
	}	
}