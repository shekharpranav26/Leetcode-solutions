# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711092276
# Status: Wrong Answer
# Date: July 25, 2025 at 08:03:48 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
