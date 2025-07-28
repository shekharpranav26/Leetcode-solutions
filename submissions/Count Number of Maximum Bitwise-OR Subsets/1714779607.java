# Title: Count Number of Maximum Bitwise-OR Subsets
# Submission ID: 1714779607
# Status: Accepted
# Date: July 28, 2025 at 09:58:48 PM GMT+5:30

import java.util.*;

public class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Compute the maximum possible OR of the entire array
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Start DFS to count subsets with OR == maxOr
        dfs(nums, 0, 0);
        return count;
    }

    // Helper DFS method
    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        // Include nums[index] in subset
        dfs(nums, index + 1, currentOr | nums[index]);

        // Exclude nums[index] from subset
        dfs(nums, index + 1, currentOr);
    }

    // Main method to run the solution with sample inputs
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 1};
        System.out.println("Output 1: " + sol.countMaxOrSubsets(nums1)); // Expected: 2

        int[] nums2 = {2, 2, 2};
        System.out.println("Output 2: " + sol.countMaxOrSubsets(nums2)); // Expected: 7

        int[] nums3 = {3, 2, 1, 5};
        System.out.println("Output 3: " + sol.countMaxOrSubsets(nums3)); // Expected: 6
    }
}
