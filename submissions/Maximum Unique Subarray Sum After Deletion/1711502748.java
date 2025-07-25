# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711502748
# Status: Internal Error
# Date: July 26, 2025 at 02:32:42 AM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        
        // Try all possible ways to delete elements (represented by bitmasks)
        for (int mask = 1; mask < (1 << n); mask++) {
            List<Integer> remaining = new ArrayList<>();
            
            // Build the array after deletions
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    remaining.add(nums[i]);
                }
            }
            
            // Find the maximum sum subarray with unique elements
            result = Math.max(result, maxUniqueSubarraySum(remaining));
        }
        
        return result;
    }
    
    private int maxUniqueSubarraySum(List<Integer> arr) {
        if (arr.isEmpty()) return Integer.MIN_VALUE;
        
        int maxSum = Integer.MIN_VALUE;
        
        // Try all possible starting positions
        for (int start = 0; start < arr.size(); start++) {
            Set<Integer> seen = new HashSet<>();
            int currentSum = 0;
            
            // Extend the subarray as long as elements are unique
            for (int end = start; end < arr.size(); end++) {
                int num = arr.get(end);
                
                if (seen.contains(num)) {
                    break; // Found duplicate, can't extend further
                }
                
                seen.add(num);
                currentSum += num;
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}