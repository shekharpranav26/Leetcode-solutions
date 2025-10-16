# Title: Smallest Missing Non-negative Integer After Operations
# Submission ID: 1803088648
# Status: Accepted
# Date: October 16, 2025 at 11:34:50 AM GMT+5:30

class Solution {

    public int findSmallestInteger(int[] nums, int value) {
        int[] mp = new int[value];
        for (int x : nums) {
            int v = ((x % value) + value) % value;
            mp[v]++;
        }
        int mex = 0;
        while (mp[mex % value] > 0) {
            mp[mex % value]--;
            mex++;
        }
        return mex;
    }
}