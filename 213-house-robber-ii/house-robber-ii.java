class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // Scenario A: Slice from 0 to n-2 (Ignore last house)
        int max1 = robLinear(nums, 0, nums.length - 2);
        
        // Scenario B: Slice from 1 to n-1 (Ignore first house)
        int max2 = robLinear(nums, 1, nums.length - 1);
        
        // The answer is the best of both worlds
        return Math.max(max1, max2);
    }
    
    // This is your exact array approach logic, just adapted for a specific range
    private int robLinear(int[] nums, int start, int end) {
        int length = end - start + 1;
        if (length == 1) return nums[start];
        
        int[] dp = new int[length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = 2; i < length; i++) {
            // nums[start + i] shifts us to the correct house in the subarray
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        
        return dp[length - 1];
    }
}