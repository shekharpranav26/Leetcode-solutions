# Title: Power of Three
# Submission ID: 1734156184
# Status: Accepted
# Date: August 14, 2025 at 12:22:19 AM GMT+5:30

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfThree(27));  // true
        System.out.println(sol.isPowerOfThree(0));   // false
        System.out.println(sol.isPowerOfThree(-1));  // false
    }
}
