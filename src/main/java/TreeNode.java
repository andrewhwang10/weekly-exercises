public class TreeNode {
    public TreeNode left;
    public TreeNode right;

    /* PRE: Assuming that both TreeNode a and b are children of cur, on first call */
    public static TreeNode lowestCommonAncestor(TreeNode cur, TreeNode a, TreeNode b) {
        if(cur == a || cur == b) {
            return cur;
        }
        TreeNode leftTree = lowestCommonAncestor(cur.left, a, b);
        TreeNode rightTree = lowestCommonAncestor(cur.right, a, b);

        if(leftTree != null && rightTree != null) {    // If both sub-trees have either a or b, current is LCA
            return cur;
        }

        if(leftTree != null) {
            return leftTree;
        } else {
            return rightTree;
        }
    }
}