# Title: Largest Perimeter Triangle
# Submission ID: 1786104224
# Status: Accepted
# Date: September 29, 2025 at 02:50:02 PM GMT+5:30

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
}