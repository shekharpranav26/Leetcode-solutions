# Title: Convert Integer to the Sum of Two No-Zero Integers
# Submission ID: 1764286835
# Status: Accepted
# Date: September 9, 2025 at 02:23:46 AM GMT+5:30

class Solution {

    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (
                !String.valueOf(A).contains("0") &&
                !String.valueOf(B).contains("0")
            ) {
                return new int[] { A, B };
            }
        }
        return new int[0];
    }
}