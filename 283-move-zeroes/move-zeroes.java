class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;  // Position to place next non-zero
        
        // Move all non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Fill remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}