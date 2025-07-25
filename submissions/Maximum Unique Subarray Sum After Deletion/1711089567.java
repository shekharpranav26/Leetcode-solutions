# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711089567
# Status: Wrong Answer
# Date: July 25, 2025 at 08:01:24 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {  // <-- renamed from maximumUniqueSubarray to maxSum
        Set<Integer> seen = new HashSet<>();
        int left = 0, currSum = 0, maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            seen.add(nums[right]);
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
