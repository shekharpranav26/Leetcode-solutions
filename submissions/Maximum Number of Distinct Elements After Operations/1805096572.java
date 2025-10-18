# Title: Maximum Number of Distinct Elements After Operations
# Submission ID: 1805096572
# Status: Accepted
# Date: October 18, 2025 at 08:56:32 PM GMT+5:30

class Solution {

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr = Math.min(Math.max(num - k, prev + 1), num + k);
            if (curr > prev) {
                cnt++;
                prev = curr;
            }
        }
        return cnt;
    }
}