# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711503541
# Status: Wrong Answer
# Date: July 26, 2025 at 02:34:15 AM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        
        // Try all possible contiguous subarrays
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> count = new HashMap<>();
            int sum = 0;
            
            for (int j = i; j < n; j++) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
                sum += nums[j];
                
                // Calculate sum if we keep only unique elements
                int uniqueSum = 0;
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    int value = entry.getKey();
                    uniqueSum += value; // Take each unique value once
                }
                
                result = Math.max(result, uniqueSum);
            }
        }
        
        return result;
    }
}