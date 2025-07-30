# Title: Longest Subarray With Maximum Bitwise AND
# Submission ID: 1717688887
# Status: Accepted
# Date: July 31, 2025 at 04:41:16 AM GMT+5:30

public class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int maxLen = 0, currentLen = 0;

        for (int num : nums) {
            if (num == max) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }

        return maxLen;
    }

    // Sample test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestSubarray(new int[]{1, 2, 3, 3, 2, 2})); // Output: 2
        System.out.println(sol.longestSubarray(new int[]{1, 2, 3, 4}));       // Output: 1
    }
}
