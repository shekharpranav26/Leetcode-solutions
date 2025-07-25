# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711507012
# Status: Wrong Answer
# Date: July 26, 2025 at 02:40:56 AM GMT+5:30

import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, currentSum = 0, maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            // Shrink window if duplicate is found
            while (set.contains(num)) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            set.add(num);
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxSum(new int[]{-20, 20}));          // 20
        System.out.println(sol.maxSum(new int[]{-100}));             // -100
        System.out.println(sol.maxSum(new int[]{1, 2, 3, 4, 5}));    // 15
        System.out.println(sol.maxSum(new int[]{1, 1, 0, 1, 1}));    // 1
        System.out.println(sol.maxSum(new int[]{1, 2, -1, -2, 1, 0, -1})); // 3
    }
}
