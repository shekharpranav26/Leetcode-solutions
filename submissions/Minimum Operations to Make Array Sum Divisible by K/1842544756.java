# Title: Minimum Operations to Make Array Sum Divisible by K
# Submission ID: 1842544756
# Status: Accepted
# Date: November 29, 2025 at 08:23:17 PM GMT+5:30

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }
        return sum%k;
    }
}