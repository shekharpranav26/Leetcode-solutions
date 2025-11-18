# Title: 1-bit and 2-bit Characters
# Submission ID: 1833501852
# Status: Accepted
# Date: November 18, 2025 at 11:52:15 PM GMT+5:30

class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}