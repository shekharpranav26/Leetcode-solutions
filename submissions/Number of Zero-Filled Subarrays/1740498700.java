# Title: Number of Zero-Filled Subarrays
# Submission ID: 1740498700
# Status: Internal Error
# Date: August 19, 2025 at 12:07:25 PM GMT+5:30

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long curr = 0; // length of current zero streak

        for (int num : nums) {
            if (num == 0) {
                curr++;       // extend streak
                count += curr; // add all subarrays ending here
            } else {
                curr = 0;     // reset streak
            }
        }

        return count;
    }
}
