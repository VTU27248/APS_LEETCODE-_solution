import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        // Leaf node
        if (node.left == null && node.right == null && node.val == target) {
            result.add(new ArrayList<>(path)); // add a copy
        } else {
            dfs(node.left, target - node.val, path, result);
            dfs(node.right, target - node.val, path, result);
        }

        path.remove(path.size() - 1); // backtrack
    }
}
