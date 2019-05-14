public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int level;		//Level 0 is root

    /* PRE: Assuming that both TreeNode a and b are in the same tree */
    public static TreeNode lowestCommonAncestor(TreeNode a, TreeNode b) {
    	while(a != b) {
    		if(a.level <= b.level) {
    			a = a.parent;
    		}
    		if(a.level >= b.level) {
    			b = b.parent;
    		}
    	}
    	return a;
    }
}