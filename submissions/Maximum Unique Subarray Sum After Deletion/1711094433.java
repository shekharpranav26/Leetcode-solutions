# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711094433
# Status: Wrong Answer
# Date: July 25, 2025 at 08:05:41 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, currentSum = 0, maxSum = Integer.MIN_VALUE;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }

        return maxSum;
    }

    // Optional: for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxSum(new int[]{1, 2, 3, 4, 5}));       // 15
        System.out.println(sol.maxSum(new int[]{1, 1, 0, 1, 1}));       // 1
        System.out.println(sol.maxSum(new int[]{1, 2, -1, -2, 1, 0, -1})); // 3
    }
}
