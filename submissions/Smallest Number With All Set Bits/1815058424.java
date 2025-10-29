# Title: Smallest Number With All Set Bits
# Submission ID: 1815058424
# Status: Accepted
# Date: October 29, 2025 at 07:18:09 PM GMT+5:30

class Solution {
    public int smallestNumber(int n) {
        for (int i = 0; i <= n; i++) {
            int z = 1 << i;
            if (z > n) return z - 1;
        }
        return 0;
    }
}