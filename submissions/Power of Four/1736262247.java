# Title: Power of Four
# Submission ID: 1736262247
# Status: Accepted
# Date: August 15, 2025 at 08:39:59 PM GMT+5:30

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}
