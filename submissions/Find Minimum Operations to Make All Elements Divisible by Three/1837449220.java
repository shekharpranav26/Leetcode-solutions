# Title: Find Minimum Operations to Make All Elements Divisible by Three
# Submission ID: 1837449220
# Status: Accepted
# Date: November 23, 2025 at 12:24:56 PM GMT+5:30

class Solution {

    public int minimumOperations(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            int rem = x % 3;
            sum += Math.min(rem, 3 - rem);
        }
        return sum;
    }
}