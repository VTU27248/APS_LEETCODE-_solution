import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastSeen.containsKey(nums[i])) {
                int prevIndex = lastSeen.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            lastSeen.put(nums[i], i);
        }

        return false;
    }
}
