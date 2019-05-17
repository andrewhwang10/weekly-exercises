public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int level;		//Level 0 is root

    /* POST: Returns null if not in same tree */
    public static TreeNode lowestCommonAncestor(TreeNode a, TreeNode b) {
    	if(a == null || b == null) {
    		throw new NullPointerException();
    	}
    	while(a != b && a != null && b != null) {
    		if(a.level <= b.level) {
    			a = a.parent;
    		}
    		if(a.level >= b.level) {
    			b = b.parent;
    		}
    	}

    	return (a == null || b == null) ? null : a;
    }
}