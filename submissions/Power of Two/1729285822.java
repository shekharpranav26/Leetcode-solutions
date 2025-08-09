# Title: Power of Two
# Submission ID: 1729285822
# Status: Accepted
# Date: August 9, 2025 at 11:52:52 PM GMT+5:30

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // Check if n is positive and has only one set bit
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfTwo(1));   // true
        System.out.println(sol.isPowerOfTwo(16));  // true
        System.out.println(sol.isPowerOfTwo(3));   // false
        System.out.println(sol.isPowerOfTwo(0));   // false
        System.out.println(sol.isPowerOfTwo(-2));  // false
    }
}
