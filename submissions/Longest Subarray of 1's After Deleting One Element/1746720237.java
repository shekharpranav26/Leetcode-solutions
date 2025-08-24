# Title: Longest Subarray of 1's After Deleting One Element
# Submission ID: 1746720237
# Status: Accepted
# Date: August 24, 2025 at 08:09:42 PM GMT+5:30

class Solution {
    public int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
                          
            // Shrink the window until the count of zero's
            // is less than or equal to 1.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
              
            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }
}