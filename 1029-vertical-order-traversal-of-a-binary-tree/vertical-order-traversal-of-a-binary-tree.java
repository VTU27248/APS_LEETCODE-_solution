import java.util.*;

class Solution {
    class NodeInfo {
        TreeNode node;
        int x, y;
        NodeInfo(TreeNode n, int x, int y) {
            this.node = n;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo cur = queue.poll();
            nodes.add(cur);

            if (cur.node.left != null)
                queue.offer(new NodeInfo(cur.node.left, cur.x - 1, cur.y + 1));
            if (cur.node.right != null)
                queue.offer(new NodeInfo(cur.node.right, cur.x + 1, cur.y + 1));
        }

        // Sort by x, then y, then value
        nodes.sort((a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            if (a.y != b.y) return a.y - b.y;
            return a.node.val - b.node.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevX = Integer.MIN_VALUE;

        for (NodeInfo ni : nodes) {
            if (ni.x != prevX) {
                result.add(new ArrayList<>());
                prevX = ni.x;
            }
            result.get(result.size() - 1).add(ni.node.val);
        }

        return result;
    }
}
