# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711505853
# Status: Wrong Answer
# Date: July 26, 2025 at 02:38:40 AM GMT+5:30

import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, currentSum = 0, maxSum = 0;

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
}
