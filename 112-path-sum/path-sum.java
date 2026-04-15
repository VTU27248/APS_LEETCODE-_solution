import java.util.*;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            int currSum = p.getValue();

            if (node.left == null && node.right == null && currSum == targetSum) {
                return true;
            }

            if (node.right != null) stack.push(new Pair<>(node.right, currSum + node.right.val));
            if (node.left != null) stack.push(new Pair<>(node.left, currSum + node.left.val));
        }

        return false;
    }
}
