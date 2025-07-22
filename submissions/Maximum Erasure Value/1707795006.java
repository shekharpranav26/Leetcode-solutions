# Title: Maximum Erasure Value
# Submission ID: 1707795006
# Status: Accepted
# Date: July 23, 2025 at 03:19:58 AM GMT+5:30

import java.util.*;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxSum = 0, currentSum = 0;

        while (right < nums.length) {
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            seen.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6})); // Output: 17
        System.out.println(sol.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5})); // Output: 8
    }
}
