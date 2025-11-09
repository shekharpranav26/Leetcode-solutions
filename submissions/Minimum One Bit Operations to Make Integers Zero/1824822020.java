# Title: Minimum One Bit Operations to Make Integers Zero
# Submission ID: 1824822020
# Status: Accepted
# Date: November 9, 2025 at 11:25:30 AM GMT+5:30

class Solution {
    public int minimumOneBitOperations(int n) {
        int res = 0;
        while (n > 0) {
            res ^= n;
            n >>= 1;
        }
        return res;
    }
}