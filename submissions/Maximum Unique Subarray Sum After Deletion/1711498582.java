# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711498582
# Status: Internal Error
# Date: July 26, 2025 at 02:25:09 AM GMT+5:30

import java.util.*;

public class Solution {
    
    public int maxSum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        
        // Try all possible ways of keeping elements (bitmask approach)
        // mask represents which elements to keep (1 = keep, 0 = delete)
        for (int mask = 1; mask < (1 << n); mask++) {
            List<Integer> remaining = new ArrayList<>();
            
            // Build the array after deletions
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    remaining.add(nums[i]);
                }
            }
            
            // Find maximum sum subarray with unique elements
            int currentMax = findMaxUniqueSubarray(remaining);
            maxSum = Math.max(maxSum, currentMax);
        }
        
        return maxSum;
    }
    
    private int findMaxUniqueSubarray(List<Integer> arr) {
        if (arr.isEmpty()) return Integer.MIN_VALUE;
        
        int n = arr.size();
        int maxSum = Integer.MIN_VALUE;
        
        // Try all possible subarrays
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            int currentSum = 0;
            
            for (int j = i; j < n; j++) {
                // If we've seen this element before, this subarray is no longer valid
                if (seen.contains(arr.get(j))) {
                    break;
                }
                
                seen.add(arr.get(j));
                currentSum += arr.get(j);
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
    
    // Test method
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + solution.maxSum(nums1)); // Expected: 15
        
        // Test case 2
        int[] nums2 = {1, 1, 0, 1, 1};
        System.out.println("Test 2: " + solution.maxSum(nums2)); // Expected: 1
        
        // Test case 3
        int[] nums3 = {1, 2, -1, -2, 1, 0, -1};
        System.out.println("Test 3: " + solution.maxSum(nums3)); // Expected: 3
        
        // Additional test cases
        int[] nums4 = {-1, -2, -3};
        System.out.println("Test 4: " + solution.maxSum(nums4)); // Expected: -1
        
        int[] nums5 = {5, 5, 5, 5};
        System.out.println("Test 5: " + solution.maxSum(nums5)); // Expected: 5
    }
}