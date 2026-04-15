class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;   // Both nodes are in left subtree
            } 
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;  // Both nodes are in right subtree
            } 
            else {
                return root;        // Split point → This is LCA
            }
        }
        return null;
    }
}