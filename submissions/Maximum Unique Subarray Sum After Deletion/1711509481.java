# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711509481
# Status: Wrong Answer
# Date: July 26, 2025 at 02:45:54 AM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, currentSum = 0, maxSum = nums[0];

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];

            while (set.contains(current)) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            set.add(current);
            currentSum += current;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Debug test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-10, -2, 6, 0, 0, 3, 8, 9, -7, -10, -8, -10, -1, -10, -7, 4, 1, -6, 4, 4, 5, -7, -2, 9, -6, 1, -8, 1, 8, -3, -5, 0, -6, -9, -4, 4, -6, 2, -3, 8, -8, -8, 7, -1, 7, 4, 10, 7, -3, 4};
        System.out.println("Expected: 55");
        System.out.println("Output: " + sol.maxSum(nums));
    }
}
