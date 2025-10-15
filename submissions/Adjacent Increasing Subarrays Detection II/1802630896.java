# Title: Adjacent Increasing Subarrays Detection II
# Submission ID: 1802630896
# Status: Accepted
# Date: October 15, 2025 at 10:39:32 PM GMT+5:30

class Solution {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int cnt = 1;
        int precnt = 0;
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++cnt;
            } else {
                precnt = cnt;
                cnt = 1;
            }
            ans = Math.max(ans, Math.min(precnt, cnt));
            ans = Math.max(ans, cnt / 2);
        }

        return ans;
    }
}