# Title: Keep Multiplying Found Values by Two
# Submission ID: 1834448085
# Status: Accepted
# Date: November 19, 2025 at 10:45:16 PM GMT+5:30

class Solution {
    public int findFinalValue(int[] nums, int k) {
        int bits = 0;
        for (int num : nums) {
            if (num % k != 0) continue;
            int n = num / k;
            if ((n & (n - 1)) == 0)
                bits |= n;
        }
        bits++;
        return k * (bits & -bits);
    }
}
