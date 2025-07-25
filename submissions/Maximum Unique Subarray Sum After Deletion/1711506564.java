# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711506564
# Status: Wrong Answer
# Date: July 26, 2025 at 02:40:06 AM GMT+5:30

import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxSum(new int[]{-100}));              // -100
        System.out.println(sol.maxSum(new int[]{-20, 20}));           // 20
        System.out.println(sol.maxSum(new int[]{1, 1, 0, 1, 1}));     // 1
        System.out.println(sol.maxSum(new int[]{1, 2, -1, -2, 1, 0, -1})); // 3
        System.out.println(sol.maxSum(new int[]{1, 2, 3, 4, 5}));     // 15
    }
}
