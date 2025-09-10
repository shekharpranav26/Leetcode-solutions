# Title: Find N Unique Integers Sum up to Zero
# Submission ID: 1766287415
# Status: Accepted
# Date: September 10, 2025 at 10:31:07 PM GMT+5:30

class Solution {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; ++i) {
            ans[index++] = i;
            ans[index++] = -i;
        }
        if (n % 2 == 1) {
            ans[index] = 0;
        }
        return ans;
    }
}