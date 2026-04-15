import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        // Base case
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Choose
            used[i] = true;
            temp.add(nums[i]);

            // Explore
            backtrack(result, temp, nums, used);

            // Backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}